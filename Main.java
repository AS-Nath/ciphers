import java.io.*;
/*
 * Note that this class uses the BufferedReader for input, while the others use the Scanner.
 * There are 2 reasons for this:
 * 1. Personal whim - wanted to play around with different tools.
 * 2. Scanner was giving trouble early in development, and BufferedReader helped me debug
 *    the issue. Did not bother to change after the problem was solved. 
 */
public class Main {
    final static InputStreamReader r = new InputStreamReader(System.in);
    final static BufferedReader br = new BufferedReader(r);

    public static void main(String[] args) throws IOException {
        mark: while (true) {
            System.out.println("Encrypt/Decrypt? [1/2] [ANYTHING ELSE TO QUIT!]");
            int a = 0;
            while (true) {
                try {
                    a = Integer.parseInt(br.readLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Exiting...");
                    break mark;
                }
            }
            int x = userInput();
            switch (a) {
                case 1:
                    encrypt(x);
                    break;
                case 2:
                    decrypt(x);
                    break;
                default:
                    System.out.println("Exiting...");
                    break mark;
            }
        }
        System.exit(1); // Exit code 1: User ended program WILLINGLY
    }

    public static void encrypt(int x) throws IOException {
        switch (x) {
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
                        if (s.equals(Decrypting.unicodeExchange(shift, ns))) {
                            ;
                        } else {
                            throw new Exception("Too large an input!");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Enter an integer! Or maybe a smaller one. [Re-enter shift value!]");
                    }
                }
                System.out.println(ns + "\n");
                break;
            case 3:
                System.out.println("Enter text to be encrypted: ");
                String i = br.readLine();
                System.out.println("Enter 8-bit binary key: ");
                String key = br.readLine();
                String enc = Encrypting.XOR(i, key);
                System.out.println(enc);
                break;
            case 2:
                System.out.println("Enter text to be encrypted: ");
                String n = br.readLine();
                int modulo = 256; // For now this is fixed.
                int publicKey = 0;
                while (true) {
                    try {
                        System.out.println("Enter public key: ");
                        publicKey = Integer.parseInt(br.readLine());
                        if (publicKey > 255) {
                            throw new Exception("Out of range 1-255");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Please enter values in the range 1-255 ONLY");
                        continue;
                    }
                }
                String encrypted = Encrypting.PK(n, modulo, publicKey);
                System.out.println(encrypted + "\n");
                break;
            default:
                System.out.println("This part should be unreachable.");
                System.exit(2); // Exit code 2: User broke the program PURPOSEFULLY :(
        }

    }

    public static void decrypt(int x) throws IOException {
        switch (x) {
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
                        } else {
                            throw new Exception("Too large!");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Enter an integer! Or maybe a smaller one. [Re-enter shift value!]");
                    }
                }
                System.out.println(ns);
                break;
            // ADD MORE CASES
            case 3:
                System.out.println("Enter text to be decrypted: ");
                String i = br.readLine();
                System.out.println("Enter 8-bit binary key: ");
                String key = br.readLine();
                String dec = Decrypting.XOR(i, key);
                System.out.println(dec);
                break;
            case 2:
                // publicKey = 123, privateKey = 133
                System.out.println("Enter text to be decrypted: ");
                String n = br.readLine();
                int modulo = 256; // For now this is fixed.
                System.out.println("Enter private key: ");
                int privateKey = Integer.parseInt(br.readLine());
                String decrypted = Decrypting.PK(n, modulo, privateKey);
                System.out.println(decrypted + "\n");
                break;
            default:
                System.out.println("This part should be unreachable");
                System.exit(2); // Exit code 2: User broke the program PURPOSEFULLY :(
        }
    }

    public static int userInput() {
        System.out.println("Encryption type | Difficulty to crack [1/2/3]");
        System.out.println("ASCII-Exchange (Substitution) | Easy");
        System.out.println("Generic Public Key Encryption | Medium");
        System.out.println("XOR | Hard");

        int a = 0;
        while (true) {
            try {
                a = Integer.parseInt(br.readLine());
                if (a != 1 && a != 2 && a != 3) {
                    throw new Exception("Not a 1/2/3");
                }
                break;
            } catch (Exception e) {
                System.out.println("Enter 1/2/3 only!");
            }
        }
        return a;
    }
}

//KEY: 01010101