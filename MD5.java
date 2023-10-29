import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MD5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> userCredentials = new HashMap<>();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter a username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter a password for " + username + ": ");
                    String password = scanner.nextLine();

                    // Hash and store the password
                    String hashedPassword = hashPasswordMD5(password);
                    userCredentials.put(username, hashedPassword);

                    System.out.println("Registration complete.");
                    break;
                case 2:
                    System.out.print("Enter your username: ");
                    String loginUsername = scanner.nextLine();

                    if (userCredentials.containsKey(loginUsername)) {
                        System.out.print("Enter your password: ");
                        String loginPassword = scanner.nextLine();

                        String storedHashedPassword = userCredentials.get(loginUsername);
                        String inputHashedPassword = hashPasswordMD5(loginPassword);

                        if (inputHashedPassword.equals(storedHashedPassword)) {
                            System.out.println("Authentication successful.");
                        } else {
                            System.out.println("Authentication failed.");
                        }
                    } else {
                        System.out.println("User not found. Please register first.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static String hashPasswordMD5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] inputBytes = password.getBytes();
            byte[] hashBytes = md.digest(inputBytes);

            // Convert the hash bytes to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("MD5 algorithm not found.");
            return null;
        }
    }
}
