package day05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        HashMap<String, Integer> studentMarks = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student name and marks (type 'exit' to finish):");

        while (true) {
            System.out.print("Student name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Marks: ");
            int marks;
            try {
                marks = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid marks input. Please enter a valid integer.");
                continue;
            }

            studentMarks.put(name, marks);
        }

        if (studentMarks.isEmpty()) {
            System.out.println("No student records to process.");
        } else {
            System.out.println("\nStudent Marks:");
            int total = 0;
            for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
                System.out.println("Name: " + entry.getKey() + ", Marks: " + entry.getValue());
                total += entry.getValue();
            }

            double average = (double) total / studentMarks.size();
            System.out.printf("Average Marks: %.2f\n", average);
        }

        scanner.close();
    }
}
