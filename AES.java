import java.util.*;
import javax.crypto.*;
import java.util.Base64;

public class AES{
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the plain Text:");
        String text=sc.nextLine();
        SecretKey key=generateAESKey();
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] encryptedBytes=cipher.doFinal(text.getBytes());
        String encryptedBase64=Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encryptedtext(Base64):"+encryptedBase64);
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] decryptedBytes=cipher.doFinal(Base64.getDecoder().decode(encryptedBase64));
        String decryptedText=new String(decryptedBytes);
        System.out.println("Decrypted Text:"+decryptedText);
    }
    private static SecretKey generateAESKey() throws Exception{
        KeyGenerator keygen=KeyGenerator.getInstance("AES");
        return keygen.generateKey();
    }
}