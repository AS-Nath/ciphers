import java.util.*;

public class Encrypting {
    static final Scanner sc = new Scanner(System.in);
    
    public static String unicodeExchange(int shift, String s) {
        String ns = "";
        for (int i = 0; i < s.length(); i++) {
            int n = (int)s.charAt(i);
            int diff = 0;
            if (Character.isUpperCase(s.charAt(i))) {
                if ((n + shift) > 90) {
                    diff = n + shift - 90;
                    n = 65 + diff - 1;
                }
                else {
                    n = n + shift;
                }
            }
            else if (Character.isLowerCase(s.charAt(i))) {
                if ((n + shift) > 122) {
                    diff = n + shift - 122;
                    n = 97 + diff - 1;
                }
                else {
                    n = n + shift;
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
        System.out.println("Enter text to be encrypted: ");
        String s = sc.nextLine();

        //Encryption process begins here
        s = s + "";    
    }

    public static String PK(String n, int modulo, int publicKey) {
        String ns = "";
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == ' ') {
                ns = ns + ' ';
                continue;
            }
            int c = (int)n.charAt(i);
            ns = ns + (char)((c + publicKey) % modulo);
        }
        return ns;
    }
}

//String.format("\\u%04x", (int) c);