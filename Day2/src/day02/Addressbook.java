package day02;

import java.util.Scanner;

public class Addressbook {
	
	    static final int MAX = 5;
	    static String[] names = new String[MAX];
	    static String[] phones = new String[MAX];
	    static int count = 0;

	    public static void addContact(String name, String phone) {
	        if (count >= MAX) {
	            System.out.println("Address book full!");
	            return;
	        }
	        names[count] = name;
	        phones[count] = phone;
	        count++;
	        System.out.println("Contact added.");
	    }

	    public static void displayContacts() {
	        if (count == 0) {
	            System.out.println("No contacts.");
	            return;
	        }
	        for (int i = 0; i < count; i++) {
	            System.out.println((i + 1) + ". " + names[i] + " - " + phones[i]);
	        }
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("1. Add Contact");
	            System.out.println("2. Display Contacts");
	            System.out.println("3. Exit");
	            System.out.print("Choice: ");
	            choice = sc.nextInt();
	            sc.nextLine(); // consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Name: ");
	                    String name = sc.nextLine();
	                    System.out.print("Phone: ");
	                    String phone = sc.nextLine();
	                    addContact(name, phone);
	                    break;
	                case 2:
	                    displayContacts();
	                    break;
	                case 3:
	                    System.out.println("Bye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice.");
	            }

	        } while (choice != 3);

	        sc.close();
	    }
	}
