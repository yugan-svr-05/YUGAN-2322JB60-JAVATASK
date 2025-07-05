package day03;

import java.util.Scanner;

public class Bankaccount {

	    private String owner;
	    private double balance;

	    public Bankaccount(String owner) {
	        this.owner = owner;
	        this.balance = 0.0;
	    }

	    public void deposit(double amount) {
	        if (amount <= 0) {
	            System.out.println("Deposit amount must be positive.");
	            return;
	        }
	        balance += amount;
	        System.out.printf("Deposited $%.2f. Current balance: $%.2f%n", amount, balance);
	    }

	    public void withdraw(double amount) {
	        if (amount <= 0) {
	            System.out.println("Withdrawal amount must be positive.");
	        } else if (amount > balance) {
	            System.out.printf("Insufficient funds. Current balance: $%.2f%n", balance);
	        } else {
	            balance -= amount;
	            System.out.printf("Withdrew $%.2f. Current balance: $%.2f%n", amount, balance);
	        }
	    }

	    public void displayAccount() {
	        System.out.printf("Account Owner: %s | Current Balance: $%.2f%n", owner, balance);
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter account owner's name: ");
	        String name = scanner.nextLine();

	        Bankaccount account = new Bankaccount(name);
	        boolean running = true;

	        while (running) {
	            System.out.println("\nChoose an action:");
	            System.out.println("1. Deposit");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Display Account Info");
	            System.out.println("4. Exit");
	            System.out.print("Enter choice: ");

	            int choice = scanner.nextInt();
	            switch (choice) {
	                case 1:
	                    System.out.print("Enter deposit amount: ");
	                    double depositAmount = scanner.nextDouble();
	                    account.deposit(depositAmount);
	                    break;
	                case 2:
	                    System.out.print("Enter withdrawal amount: ");
	                    double withdrawAmount = scanner.nextDouble();
	                    account.withdraw(withdrawAmount);
	                    break;
	                case 3:
	                    account.displayAccount();
	                    break;
	                case 4:
	                    System.out.println("Exiting. Thank you!");
	                    running = false;
	                    break;
	                default:
	                    System.out.println("Invalid choice. Try again.");
	            }
	        }

	        scanner.close();
	    }
	}
