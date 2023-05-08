import java.io.*;
/*
 * Note that this class uses the BufferedReader for input, while the others use the Scanner.
 * There are 2 reasons for this:
 * 1. Personal whim - wanted to play around with different tools.
 * 2. Scanner was giving trouble early in development, and BufferedReader helped me debug
 *    the issue. Did not bother to change after the problem was solved. 
 */

//TODO: Re-write input validation as a separate function

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
                catch (NumberFormatException e) {
                    System.out.println("Exiting...");
                    break mark;
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

        int a = 0;
        while (true) {
            try {
                a = Integer.parseInt(br.readLine());
                if (a != 1 && a != 2 && a != 3) {
                    throw new Exception("Not a 1/2/3");
                }
                break;
            }
            catch (Exception e) {
                System.out.println("Enter 1/2/3 only!");
            }
        }

        switch(a) {
            case 1:
                System.out.println("Shift by: [Enter an integer]");
                int shift = 0;
                String ns = "";
                String s = "";
                while (true) {
                    try {
                        shift = Integer.parseInt(br.readLine());
                        System.out.println("Enter text to be encrypted: ");
                        s = br.readLine();
                        ns = Encrypting.unicodeExchange(shift, s);
                        if (s.equals(Decrypting.unicodeExchange(shift, ns)))
                        {
                            ;
                        }
                        else {
                            throw new Exception("Too large an input!");
                        }
                        break;
                    }
                    catch (Exception e) {
                        System.out.println("Enter an integer! Or maybe a smaller one. [Re-enter shift value!]");
                    }
                }
                System.out.println(ns + "\n");
                break;
            case 2:
                Encrypting.RSA();
                break;
            case 3:
                Encrypting.AES();
                break;
            default:
                System.out.println("This part should be unreachable.");
                System.exit(2); //Exit code 2: User broke the program PURPOSEFULLY :(
        }

    }
    public static void decrypt() throws IOException {
        System.out.println("Encryption type | Difficulty to crack [1/2/3]");
        System.out.println("Unicode-Exchange (Substitution) | Easy");
        System.out.println("RSA | Hard");
        System.out.println("AES | Impossible");

        int a = 0;
        while (true) {
            try {
                a = Integer.parseInt(br.readLine());
                if (a != 1 && a != 2 && a != 3) {
                    throw new Exception("Not a 1/2/3");
                }
                break;
            }
            catch (Exception e) {
                System.out.println("Enter 1/2/3 only!");
            }
        }

        switch(a) {
            case 1:
                System.out.println("Shift by: [Enter an integer]");
                int shift = 0;
                String s = "";
                String ns = "";
                while (true) {
                    try {
                        shift = Integer.parseInt(br.readLine());
                        System.out.println("Enter text to be decrypted: ");
                        s = br.readLine();
                        ns = Decrypting.unicodeExchange(shift, s);
                        if (s.equals(Encrypting.unicodeExchange(shift, ns))) {
                            ;
                        }
                        else {
                            throw new Exception("Too large!");
                        }
                        break;
                    }
                    catch (Exception e) {
                        System.out.println("Enter an integer! Or maybe a smaller one. [Re-enter shift value!]");
                    }
                }
                System.out.println(ns);
                break;
            //ADD MORE CASES
            case 2:
                Decrypting.RSA();
                break;
            case 3:
                Decrypting.AES();
                break;
            default:
                System.out.println("This part should be unreachable");
                System.exit(2); //Exit code 2: User broke the program PURPOSEFULLY :(
        }


    }
}