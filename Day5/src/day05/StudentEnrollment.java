package day05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class StudentEnrollment {


	    static ArrayList<String> students = new ArrayList<>();
	    static HashMap<String, ArrayList<String>> enrollmentMap = new HashMap<>();
	    static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int choice;
	        do {
	            System.out.println("\n=== Student Course Enrollment System ===");
	            System.out.println("1. Add Student");
	            System.out.println("2. Remove Student");
	            System.out.println("3. Enroll Student in Course");
	            System.out.println("4. Remove Student from Course");
	            System.out.println("5. Display All Students and Their Courses");
	            System.out.println("6. Exit");
	            System.out.print("Enter choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine(); // consume newline

	            switch (choice) {
	                case 1 -> addStudent();
	                case 2 -> removeStudent();
	                case 3 -> enrollCourse();
	                case 4 -> removeCourse();
	                case 5 -> displayAll();
	                case 6 -> System.out.println("Exiting...");
	                default -> System.out.println("Invalid choice! Try again.");
	            }
	        } while (choice != 6);
	    }

	    static void addStudent() {
	        System.out.print("Enter student name to add: ");
	        String student = scanner.nextLine().trim();
	        if (student.isEmpty()) {
	            System.out.println("Student name cannot be empty.");
	            return;
	        }
	        if (students.contains(student)) {
	            System.out.println("Student already exists.");
	        } else {
	            students.add(student);
	            enrollmentMap.put(student, new ArrayList<>());
	            System.out.println("Student added: " + student);
	        }
	    }

	    static void removeStudent() {
	        System.out.print("Enter student name to remove: ");
	        String student = scanner.nextLine().trim();
	        if (students.remove(student)) {
	            enrollmentMap.remove(student);
	            System.out.println("Student removed: " + student);
	        } else {
	            System.out.println("Student not found.");
	        }
	    }

	    static void enrollCourse() {
	        System.out.print("Enter student name to enroll: ");
	        String student = scanner.nextLine().trim();
	        if (!students.contains(student)) {
	            System.out.println("Student not found.");
	            return;
	        }

	        System.out.print("Enter course name to enroll: ");
	        String course = scanner.nextLine().trim();
	        if (course.isEmpty()) {
	            System.out.println("Course name cannot be empty.");
	            return;
	        }

	        ArrayList<String> courses = enrollmentMap.get(student);
	        if (courses.contains(course)) {
	            System.out.println(student + " is already enrolled in " + course);
	        } else {
	            courses.add(course);
	            System.out.println("Enrolled " + student + " in course: " + course);
	        }
	    }

	    static void removeCourse() {
	        System.out.print("Enter student name to remove course from: ");
	        String student = scanner.nextLine().trim();
	        if (!students.contains(student)) {
	            System.out.println("Student not found.");
	            return;
	        }

	        System.out.print("Enter course name to remove: ");
	        String course = scanner.nextLine().trim();

	        ArrayList<String> courses = enrollmentMap.get(student);
	        if (courses.remove(course)) {
	            System.out.println("Removed course " + course + " from " + student);
	        } else {
	            System.out.println(student + " is not enrolled in " + course);
	        }
	    }

	    static void displayAll() {
	        if (students.isEmpty()) {
	            System.out.println("No students enrolled.");
	            return;
	        }

	        System.out.println("\n--- Student Course Enrollments ---");
	        Iterator<String> studentIter = students.iterator();

	        while (studentIter.hasNext()) {
	            String student = studentIter.next();
	            System.out.print("Student: " + student + " | Courses: ");

	            ArrayList<String> courses = enrollmentMap.get(student);
	            if (courses.isEmpty()) {
	                System.out.println("None");
	            } else {
	                Iterator<String> courseIter = courses.iterator();
	                while (courseIter.hasNext()) {
	                    System.out.print(courseIter.next());
	                    if (courseIter.hasNext()) {
	                        System.out.print(", ");
	                    }
	                }
	                System.out.println();
	            }
	        }
	    }
	}
