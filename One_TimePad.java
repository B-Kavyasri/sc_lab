import java.util.Scanner;

public class One_TimePad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine();
        System.out.print("Enter key (same length as plaintext): ");
        String key = scanner.nextLine();

        if (plaintext.length() != key.length()) {
            System.out.println("Plaintext and key lengths must be the same.");
            return;
        }
        
        String encryptedText = processText(plaintext, key, true);
        String decryptedText = processText(encryptedText, key, false);

        System.out.println("Encrypted text (in binary): " + textToBinary(encryptedText));
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }

    public static String textToBinary(String text) {
        StringBuilder binaryText = new StringBuilder();
        for (char c : text.toCharArray()) {
            binaryText.append(String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0'));
        }
        return binaryText.toString();
    }

    public static String binaryToText(String binary) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 8) {
            text.append((char) Integer.parseInt(binary.substring(i, i + 8), 2));
        }
        return text.toString();
    }

    public static String processText(String text, String key, boolean encrypt) {
        StringBuilder processedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char t = text.charAt(i);
            char k = key.charAt(i);
            char processedChar = encrypt ? (char) (t ^ k) : (char) (t ^ k);
            processedText.append(processedChar);
        }
        return processedText.toString();
    }
}