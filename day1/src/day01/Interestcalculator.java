package day01;

import java.util.Scanner;

public class Interestcalculator {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter Principal (P): ");
	        double principal = scanner.nextDouble();

	        System.out.print("Enter Rate of Interest (R): ");
	        double rate = scanner.nextDouble();

	        System.out.print("Enter Time in years (T): ");
	        double time = scanner.nextDouble();

	        if (principal <= 0 || rate <= 0 || time <= 0) {
	            System.out.println("Please enter positive values for P, R, and T.");
	        } else {
	            double interest = (principal * rate * time) / 100;
	            System.out.println("Simple Interest = " + interest);
	        }

	        scanner.close();
	    }
	}