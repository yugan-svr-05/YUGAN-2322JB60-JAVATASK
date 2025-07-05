package day01;

import java.util.Scanner;

public class Calculator {

	    public Calculator() {
	        // Default constructor
	    }

	    public double add(double a, double b) {
	        return a + b;
	    }

	    public double subtract(double a, double b) {
	        return a - b;
	    }

	    public double multiply(double a, double b) {
	        return a * b;
	    }

	    public double divide(double a, double b) {
	        if (b == 0) {
	            System.out.println("Error: Division by zero is not allowed.");
	            return Double.NaN;
	        }
	        return a / b;
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Calculator calculator = new Calculator();

	        boolean continueCalc = true;

	        while (continueCalc) {
	            System.out.println("\nMenu:");
	            System.out.println("1. Add");
	            System.out.println("2. Subtract");
	            System.out.println("3. Multiply");
	            System.out.println("4. Divide");
	            System.out.println("5. Exit");
	            System.out.print("Choose an operation (1-5): ");

	            int choice = scanner.nextInt();

	            if (choice == 5) {
	                System.out.println("Exiting calculator. Goodbye!");
	                break;
	            }

	            System.out.print("Enter first number: ");
	            double num1 = scanner.nextDouble();

	            System.out.print("Enter second number: ");
	            double num2 = scanner.nextDouble();

	            double result;

	            switch (choice) {
	                case 1:
	                    result = calculator.add(num1, num2);
	                    System.out.println("Result: " + result);
	                    break;
	                case 2:
	                    result = calculator.subtract(num1, num2);
	                    System.out.println("Result: " + result);
	                    break;
	                case 3:
	                    result = calculator.multiply(num1, num2);
	                    System.out.println("Result: " + result);
	                    break;
	                case 4:
	                    result = calculator.divide(num1, num2);
	                    if (!Double.isNaN(result)) {
	                        System.out.println("Result: " + result);
	                    }
	                    break;
	                default:
	                    System.out.println("Invalid choice! Please select 1-5.");
	            }
	        }

	        scanner.close();
	    }
	}
