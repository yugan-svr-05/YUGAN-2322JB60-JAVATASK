package day04;

import java.io.*;
import java.util.*;

public class EmployeeRecordSystem {
    static final String FILE_NAME = "employees.txt";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Employee Record System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewAllEmployees();
                case 3 -> searchEmployee();
                case 4 -> updateEmployee();
                case 5 -> deleteEmployee();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);
    }

    static void addEmployee() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            System.out.print("Enter Employee ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Age: ");
            String age = scanner.nextLine();
            System.out.print("Enter Department: ");
            String dept = scanner.nextLine();

            bw.write(id + "," + name + "," + age + "," + dept);
            bw.newLine();
            System.out.println("Employee added successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    static void viewAllEmployees() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- All Employees ---");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println("ID: " + parts[0] + ", Name: " + parts[1] +
                        ", Age: " + parts[2] + ", Dept: " + parts[3]);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        String searchId = scanner.nextLine();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(searchId)) {
                    System.out.println("Found: ID=" + parts[0] + ", Name=" + parts[1] +
                            ", Age=" + parts[2] + ", Dept=" + parts[3]);
                    found = true;
                    break;
                }
            }

            if (!found) System.out.println("Employee ID not found.");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        String updateId = scanner.nextLine();
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        boolean updated = false;

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(updateId)) {
                    System.out.print("Enter new Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter new Age: ");
                    String age = scanner.nextLine();
                    System.out.print("Enter new Department: ");
                    String dept = scanner.nextLine();
                    bw.write(updateId + "," + name + "," + age + "," + dept);
                    bw.newLine();
                    updated = true;
                } else {
                    bw.write(line);
                    bw.newLine();
                }
            }

            if (updated) {
                if (inputFile.delete()) {
                    tempFile.renameTo(inputFile);
                    System.out.println("Employee updated successfully.");
                }
            } else {
                System.out.println("Employee ID not found.");
                tempFile.delete();
            }

        } catch (IOException e) {
            System.err.println("Error updating file: " + e.getMessage());
        }
    }

    static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        String deleteId = scanner.nextLine();
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        boolean deleted = false;

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (!parts[0].equals(deleteId)) {
                    bw.write(line);
                    bw.newLine();
                } else {
                    deleted = true;
                }
            }

            if (deleted) {
                if (inputFile.delete()) {
                    tempFile.renameTo(inputFile);
                    System.out.println("Employee deleted successfully.");
                }
            } else {
                System.out.println("Employee ID not found.");
                tempFile.delete();
            }

        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
        }
    }
}

