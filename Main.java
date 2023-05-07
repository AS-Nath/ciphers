import java.io.*;
/*
 * Note that this class uses the BufferedReader for input, while the others use the Scanner.
 * There are 2 reasons for this:
 * 1. Personal whim - wanted to play around with different tools.
 * 2. Scanner was giving trouble early in development, and BufferedReader helped me debug
 *    the issue. Did not bother to change after the problem was solved. 
 */

 //TODO: Add the AES case to all 3 classes.
 //TODO: Implement a cipher.

public class Main {
    final static InputStreamReader r = new InputStreamReader(System.in);
    final static BufferedReader br = new BufferedReader(r);
    public static void main(String[] args) throws IOException {
        mark: while (true) {
            System.out.println("Encrypt/Decrypt? [1/2] [ANYTHING ELSE TO QUIT!]");
            int a = 0;
            while(true) {
                try {
                    a = Integer.parseInt(br.readLine());
                    break;
                }
                catch (IOException e) {
                    System.out.println("Input Error. This happens only in testing. Please contact developer immediately.");
                }
            }
            switch(a) {
                case 1:
                    encrypt();
                    break;
                case 2:
                    decrypt();
                    break;
                default:
                    System.out.println("Exiting...");
                    break mark;
            }
        }
        System.exit(1); //Exit code 1: User ended program WILLINGLY
    }

    public static void encrypt() throws IOException {
        System.out.println("Encryption type | Difficulty to crack [1/2/3]");
        System.out.println("Unicode-Exchange (Substitution) | Easy");
        System.out.println("RSA | Hard");
        System.out.println("AES | Impossible");

        int a = Integer.parseInt(br.readLine());

        switch(a) {
            case 1:
                System.out.println("Shift by: [Enter an integer]");
                int shift = Integer.parseInt(br.readLine());
                Encrypting.unicodeExchange(shift);
                break;
            //ADD MORE CASES
            case 2:
                Encrypting.RSA();
                break;
            case 3:
                Encrypting.AES();
                break;
            default:
                System.out.println("Wrong input - Start again.");
                System.exit(2); //Exit code 2: User broke the program PURPOSEFULLY :(
        }

    }
    public static void decrypt() throws IOException {
        System.out.println("Encryption type | Difficulty to crack [1/2/3]");
        System.out.println("Unicode-Exchange (Substitution) | Easy");
        System.out.println("RSA | Hard");
        System.out.println("AES | Impossible");

        int a = Integer.parseInt(br.readLine());

        switch(a) {
            case 1:
                System.out.println("Shift by: [Enter an integer]");
                int shift = Integer.parseInt(br.readLine());
                Decrypting.unicodeExchange(shift);
                break;
            //ADD MORE CASES
            case 2:
                Decrypting.RSA();
                break;
            case 3:
                Decrypting.AES();
                break;
            default:
                System.out.println("Wrong input - Start again.");
                System.exit(2); //Exit code 2: User broke the program PURPOSEFULLY :(
        }


    }
}