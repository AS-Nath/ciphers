import java.util.*;

public class Decrypting {

    static final Scanner sc = new Scanner(System.in);

    public static String unicodeExchange(int shift, String s) {
        String ns = "";
        for (int i = 0; i < s.length(); i++) {
            int n = (int)s.charAt(i);
            int diff = 0;
            if (Character.isUpperCase(s.charAt(i))) {
                if ((n - shift) < 65) {
                    diff = 65 - (n - shift);
                    n = 90 - diff + 1;
                }
                else {
                    n = n - shift;
                }
            }
            else if (Character.isLowerCase(s.charAt(i))) {
                if ((n - shift) < 97) {
                    diff = 97 - (n - shift);
                    n = 122 - diff + 1;
                }
                else {
                    n = n - shift;
                }
            }
            else {
                ; // If we don't have a letter (e.g. $%#$%4353445) then leave as is.
            }
            ns = ns + (char)n;
        }
        return ns;
    }

    public static void RSA() {
        System.out.println("Enter text to be decrypted: ");
        String s = sc.nextLine();

        s = s + "";
    }

    public static void AES() {
        System.out.println("AES");
    }
}
