package day04;

import java.util.Scanner;

public class DivideByZero {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        try {
	            // Input
	            System.out.print("Enter numerator: ");
	            int numerator = scanner.nextInt();

	            System.out.print("Enter denominator: ");
	            int denominator = scanner.nextInt();

	            // Division operation
	            int result = numerator / denominator;

	            // Output result
	            System.out.println("Result: " + result);
	        } catch (ArithmeticException e) {
	            // Handle division by zero
	            System.out.println("Error: Cannot divide by zero!");
	        } catch (Exception e) {
	            // Handle other input-related exceptions
	            System.out.println("Error: Invalid input.");
	        } finally {
	            // Optional: clean up resources
	            scanner.close();
	            System.out.println("Program ended.");
	        }
	    }
	}
