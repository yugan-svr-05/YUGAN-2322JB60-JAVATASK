package day03;

import java.util.Scanner;

public class Overloading {

	    // Overloaded sum method for integers
	    public int sum(int a, int b) {
	        return a + b;
	    }

	    // Overloaded sum method for doubles
	    public double sum(double a, double b) {
	        return a + b;
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Overloading calc = new Overloading();

	        System.out.println("Choose operation type:");
	        System.out.println("1. Sum of integers");
	        System.out.println("2. Sum of doubles");
	        System.out.print("Enter choice (1 or 2): ");
	        int choice = scanner.nextInt();

	        switch (choice) {
	            case 1:
	                System.out.print("Enter first integer: ");
	                int int1 = scanner.nextInt();
	                System.out.print("Enter second integer: ");
	                int int2 = scanner.nextInt();
	                int intResult = calc.sum(int1, int2);
	                System.out.println("Sum of integers: " + intResult);
	                break;

	            case 2:
	                System.out.print("Enter first double: ");
	                double double1 = scanner.nextDouble();
	                System.out.print("Enter second double: ");
	                double double2 = scanner.nextDouble();
	                double doubleResult = calc.sum(double1, double2);
	                System.out.println("Sum of doubles: " + doubleResult);
	                break;

	            default:
	                System.out.println("Invalid choice.");
	        }

	        scanner.close();
	    }
	}
