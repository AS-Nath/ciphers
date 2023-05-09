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

    public static String XOR(String n, String key) {
        char[] arr = new char[n.length()];
        for (int i = 0; i < n.length(); i++) {
            arr[i] = n.charAt(i);
        }
        String[] binaryArray = new String[n.length()];
        for (int i = 0; i < n.length(); i++) {
            int num = (int)arr[i];
            binaryArray[i] = Integer.toBinaryString(0x100 | num).substring(1);
        }
        for (int i = 0; i < n.length(); i++) {
            binaryArray[i] = applyXOR(binaryArray[i], key);
        }
        for (int i = 0; i < n.length(); i++) {
            arr[i] = (char)Integer.parseInt(binaryArray[i], 2);
        }
        String ns = "";
        for (int i = 0; i < arr.length; i++) {
            ns = ns + arr[i];
        }        
        return ns; 
    }

    public static String PK(String n, int modulo, int privateKey) {
        String ns = "";
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == ' ') {
                ns = ns + ' ';
                continue;
            }
            int c = (int)n.charAt(i);
            ns = ns + (char)((c + privateKey) % modulo);
        }
        return ns;
    }
    public static String applyXOR(String n, String key) {
        String ns = "";
        for (int i = 0; i < n.length(); i++) {
            int val1 = Integer.parseInt(Character.toString(n.charAt(i)));
            int val2 = Integer.parseInt(Character.toString(key.charAt(i)));
            int val = val1^val2;
            ns = ns + Integer.toString(val);
        }
        return ns;
    }
}
