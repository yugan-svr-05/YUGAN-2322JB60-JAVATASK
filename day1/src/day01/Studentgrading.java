package day01;

import java.util.Scanner;

public class Studentgrading {

	    public Studentgrading() {
	        // Default constructor
	    }

	    public char getGrade(int marks) {
	        if (marks >= 90) {
	            return 'A';
	        } else if (marks >= 80) {
	            return 'B';
	        } else if (marks >= 70) {
	            return 'C';
	        } else if (marks >= 60) {
	            return 'D';
	        } else {
	            return 'F';
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Studentgrading grader = new Studentgrading();

	        System.out.print("Enter student marks (0-100): ");
	        int marks = scanner.nextInt();

	        if (marks < 0 || marks > 100) {
	            System.out.println("Invalid marks! Please enter between 0 and 100.");
	        } else {
	            char grade = grader.getGrade(marks);
	            System.out.println("Marks: " + marks);
	            System.out.println("Grade: " + grade);
	        }

	        scanner.close();
	    }
	}
