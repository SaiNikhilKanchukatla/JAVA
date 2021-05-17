import edu.duke.*;

public class CaesarCipher {

    public String encrypt(String input, int key) {
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        StringBuffer encrypt = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (curr >= 'A' && curr <= 'Z') {
                int index = (curr - 'A' + key) % 26;
                encrypt.append(Alphabet.charAt(index));
            } else if (curr >= 'a' && curr <= 'z') {
                int index = (curr - 'a' + key) % 26;
                encrypt.append(alphabets.charAt(index));
            } else
                encrypt.append(" ");
        }
        return encrypt.toString();
    }

    public void testCaesar() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int key = 23;

        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }

    public String encryptTwoKeys(String input, int key1, int key2) {
        String Alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String aplhabets = "abcdefghijklmnopqrstuvwxyz";
        StringBuffer encrypt_two = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (i % 2 == 0) {
                if (curr >= 'A' && curr <= 'Z') {
                    int index = (curr - 'A' + key1) % 26;
                    encrypt_two.append(Alphabets.charAt(index));
                } else if (curr >= 'a' && curr <= 'z') {
                    int index = (curr - 'a' + key1) % 26;
                    encrypt_two.append(aplhabets.charAt(index));
                } else
                    encrypt_two.append(" ");
            } else {
                if (curr >= 'A' && curr <= 'Z') {
                    int index = (curr - 'A' + key2) % 26;
                    encrypt_two.append(Alphabets.charAt(index));
                } else if (curr >= 'a' && curr <= 'z') {
                    int index = (curr - 'a' + key2) % 26;
                    encrypt_two.append(aplhabets.charAt(index));
                } else
                    encrypt_two.append(" ");
            }
        }
        return encrypt_two.toString();
    }

    public void testEncryptTwoKeys() {
        String message = "First Legion";
        int key1 = 23;
        int key2 = 17;
        System.out.println(message + " -> " + encryptTwoKeys(message, key1, key2));
    }

}
class Main{
    public static void main(String args[]){
        CaesarCipher object = new CaesarCipher();
        object.testCaesar();
        object.testEncryptTwoKeys();
    }

}

