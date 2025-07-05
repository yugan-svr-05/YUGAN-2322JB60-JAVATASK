package day05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class StudentManagementApp {

	    static ArrayList<String> studentNames = new ArrayList<>();
	    static HashMap<String, ArrayList<String>> studentCourses = new HashMap<>();
	    static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int choice;
	        do {
	            System.out.println("\n=== Student Management App ===");
	            System.out.println("1. Add Student");
	            System.out.println("2. Add Course to Student");
	            System.out.println("3. Search Student by ID");
	            System.out.println("4. Delete Student");
	            System.out.println("5. Delete Course from Student");
	            System.out.println("6. Display All Students and Courses");
	            System.out.println("7. Save Courses to File");
	            System.out.println("8. Exit");
	            System.out.print("Enter choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine(); // consume newline

	            switch (choice) {
	                case 1 -> addStudent();
	                case 2 -> addCourse();
	                case 3 -> searchStudent();
	                case 4 -> deleteStudent();
	                case 5 -> deleteCourse();
	                case 6 -> displayAll();
	                case 7 -> saveToFile();
	                case 8 -> System.out.println("Exiting...");
	                default -> System.out.println("Invalid choice!");
	            }
	        } while (choice != 8);
	    }

	    static void addStudent() {
	        System.out.print("Enter Student ID: ");
	        String id = scanner.nextLine();
	        if (studentCourses.containsKey(id)) {
	            System.out.println("Student ID already exists!");
	            return;
	        }

	        System.out.print("Enter Student Name: ");
	        String name = scanner.nextLine();
	        studentNames.add(name);
	        studentCourses.put(id, new ArrayList<>());
	        System.out.println("Student added: " + name + " (ID: " + id + ")");
	    }

	    static void addCourse() {
	        System.out.print("Enter Student ID: ");
	        String id = scanner.nextLine();

	        if (!studentCourses.containsKey(id)) {
	            System.out.println("Student ID not found.");
	            return;
	        }

	        System.out.print("Enter course to add: ");
	        String course = scanner.nextLine();

	        ArrayList<String> courses = studentCourses.get(id);
	        if (courses.contains(course)) {
	            System.out.println("Course already assigned.");
	        } else {
	            courses.add(course);
	            System.out.println("Course added to student.");
	        }
	    }

	    static void searchStudent() {
	        System.out.print("Enter Student ID to search: ");
	        String id = scanner.nextLine();

	        if (studentCourses.containsKey(id)) {
	            System.out.println("Student ID: " + id);
	            ArrayList<String> courses = studentCourses.get(id);
	            System.out.println("Courses: " + (courses.isEmpty() ? "None" : courses));
	        } else {
	            System.out.println("Student ID not found.");
	        }
	    }

	    static void deleteStudent() {
	        System.out.print("Enter Student ID to delete: ");
	        String id = scanner.nextLine();

	        if (studentCourses.remove(id) != null) {
	            System.out.println("Student deleted.");
	        } else {
	            System.out.println("Student ID not found.");
	        }
	    }

	    static void deleteCourse() {
	        System.out.print("Enter Student ID: ");
	        String id = scanner.nextLine();

	        if (!studentCourses.containsKey(id)) {
	            System.out.println("Student ID not found.");
	            return;
	        }

	        System.out.print("Enter course to remove: ");
	        String course = scanner.nextLine();

	        ArrayList<String> courses = studentCourses.get(id);
	        if (courses.remove(course)) {
	            System.out.println("Course removed.");
	        } else {
	            System.out.println("Course not found for student.");
	        }
	    }

	    static void displayAll() {
	        System.out.println("\n--- All Students and Their Courses ---");
	        for (Map.Entry<String, ArrayList<String>> entry : studentCourses.entrySet()) {
	            String id = entry.getKey();
	            ArrayList<String> courses = entry.getValue();
	            System.out.println("ID: " + id + " | Courses: " + (courses.isEmpty() ? "None" : courses));
	        }
	    }

	    static void saveToFile() {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("courses.txt"))) {
	            for (Map.Entry<String, ArrayList<String>> entry : studentCourses.entrySet()) {
	                writer.write("ID: " + entry.getKey() + " - Courses: " + entry.getValue());
	                writer.newLine();
	            }
	            System.out.println("Course list saved to courses.txt");
	        } catch (IOException e) {
	            System.out.println("Error writing to file: " + e.getMessage());
	        }
	    }
	}
