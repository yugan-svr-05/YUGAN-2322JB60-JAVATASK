package day05;

import java.util.HashSet;
import java.util.Scanner;

public class UniqueEmails {
    public static void main(String[] args) {
        HashSet<String> emailSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter email addresses (type 'exit' to stop):");

        while (true) {
            String email = scanner.nextLine();
            if (email.equalsIgnoreCase("exit")) {
                break;
            }

            // Add email to HashSet (duplicates automatically ignored)
            if (emailSet.add(email)) {
                System.out.println("Added: " + email);
            } else {
                System.out.println("Duplicate email ignored: " + email);
            }
        }

        System.out.println("\nUnique email addresses entered:");
        for (String e : emailSet) {
            System.out.println(e);
        }

        scanner.close();
    }
}
