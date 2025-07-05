package day03;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private String id;
    private int[] marks = new int[3];

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void assignMarks(int m1, int m2, int m3) {
        marks[0] = m1;
        marks[1] = m2;
        marks[2] = m3;
    }

    public void displayResult() {
        System.out.println("Student: " + name + " (ID: " + id + ")");
        System.out.println("Marks: " + marks[0] + ", " + marks[1] + ", " + marks[2]);
        double average = (marks[0] + marks[1] + marks[2]) / 3.0;
        System.out.printf("Average: %.2f%n", average);
        System.out.println("-----------------------");
    }

    public String getId() {
        return id;
    }
}

public class StudentManagementSystem {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("Student Management System");
            System.out.println("1. Create Student");
            System.out.println("2. Assign Marks");
            System.out.println("3. Display Results");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    assignMarks();
                    break;
                case 3:
                    displayResults();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    static void createStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        // Check if student with same ID already exists
        for (Student s : students) {
            if (s.getId().equals(id)) {
                System.out.println("Student ID already exists. Creation failed.");
                return;
            }
        }

        Student newStudent = new Student(name, id);
        students.add(newStudent);
        System.out.println("Student created successfully.");
    }

    static void assignMarks() {
        System.out.print("Enter student ID to assign marks: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter marks for subject 1: ");
        int m1 = scanner.nextInt();
        System.out.print("Enter marks for subject 2: ");
        int m2 = scanner.nextInt();
        System.out.print("Enter marks for subject 3: ");
        int m3 = scanner.nextInt();
        scanner.nextLine(); // consume newline

        student.assignMarks(m1, m2, m3);
        System.out.println("Marks assigned successfully.");
    }

    static void displayResults() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student s : students) {
            s.displayResult();
        }
    }

    static Student findStudentById(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) return s;
        }
        return null;
    }
}
