import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;
public class RSADemo {
    private final static BigInteger one = new BigInteger("1");
    private final static SecureRandom random = new SecureRandom();
    private BigInteger privatekey;
    private BigInteger publicKey;
    private BigInteger modulus;

    // generate an N-bit (roughly) public and private key
    RSADemo(int N) {
        BigInteger p = BigInteger.probablePrime(N / 2, random);
        BigInteger q = BigInteger.probablePrime(N / 2, random);

        modulus = p.multiply(q);

        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
        System.out.println("prime p= " + p);
        System.out.println("prime q= " + q);

        publicKey = new BigInteger("65537"); // common value in practice - 2^16+1
        privatekey = publicKey.modInverse(phi);
        System.out.println("phi= " + phi);
    }

    BigInteger encrypt(BigInteger message) {
        return message.modPow(publicKey, modulus);
    }

    BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(privatekey, modulus);
    }

    public String toString() {
        String s = "";
        s += "public= " + publicKey + "\n";
        s += "private= " + privatekey + "\n";
        s += "modulus= " + modulus;
        return s;
    }

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        System.out.print("Enter bit length of key: ");
        int N = ob.nextInt();
        RSADemo key = new RSADemo(N);
        System.out.println(key);

        // create random message, encrypt and decrypt.
        BigInteger message = new BigInteger("8"); // create message by converting string to integer

        BigInteger encrypt = key.encrypt(message);
        BigInteger decrypt = key.decrypt(encrypt);

        System.out.println("message: " + message);
        System.out.println("encrypted: " + encrypt);
        System.out.println("decrypted: " + decrypt);
    }
}