import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException; 
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;
public class MD5MACExample {
    public static void main(String[] args) {
        try {
        Scanner sc=new Scanner(System.in);
            String secretKey = sc.nextLine(); 
            String message = sc.nextLine();        
            byte[] mac = generateMD5MAC(secretKey, message.getBytes());
           System.out.println("Original Message: " + message);
            System.out.println("Generated MAC: " + bytesToHex(mac));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }
    private static byte[] generateMD5MAC(String secretKey, byte[] message) throws NoSuchAlgorithmException, InvalidKeyException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] keyBytes = secretKey.getBytes();
        Key key = new SecretKeySpec(keyBytes, "HmacMD5");
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        return mac.doFinal(message);
    }
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}