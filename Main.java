import java.util.*;

public class Main {

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mark: while (true) {
            System.out.println("Encrypt/Decrypt? [1/2] [ANYTHING ELSE TO QUIT!]");
            int a = sc.nextInt();
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
        sc.close();
        System.exit(1); //Exit code 1: User ended program WILLINGLY
    }

    public static void encrypt() {
        System.out.println("Encryption type | Difficulty to crack [1/2/3]");
        System.out.println("Unicode-Exchange (Substitution) | Easy");
        System.out.println("Polybius Cipher | Medium");
        System.out.println("AES | Impossible");

        int a = sc.nextInt();

        switch(a) {
            case 1:
                System.out.println("Shift by: [Enter an integer]");
                int shift = sc.nextInt();
                Encrypting.unicodeExchange(shift);
                break;
            //ADD MORE CASES
            default:
                System.out.println("Wrong input - Start again.");
                System.exit(2); //Exit code 2: User broke the program PURPOSEFULLY :(
        }

    }
    public static void decrypt() {
        System.out.println("Encryption type | Difficulty to crack [1/2/3]");
        System.out.println("Unicode-Exchange (Substitution) | Easy");
        System.out.println("Polybius Cipher | Medium");
        System.out.println("AES | Impossible");

        int a = sc.nextInt();

        switch(a) {
            case 1:
                System.out.println("Shift by: [Enter an integer]");
                int shift = sc.nextInt();
                Decrypting.unicodeExchange(shift);
                break;
            //ADD MORE CASES
            default:
                System.out.println("Wrong input - Start again.");
                System.exit(2); //Exit code 2: User broke the program PURPOSEFULLY :(
        }


    }
}