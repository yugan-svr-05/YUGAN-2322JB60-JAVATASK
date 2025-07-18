package day06;

import java.util.Scanner;

//Shared resource: TicketBookingSystem
class TicketBookingSystem {
 private int availableSeats;

 public TicketBookingSystem(int totalSeats) {
     this.availableSeats = totalSeats;
 }

 // Synchronized booking method
 public synchronized void bookTicket(String userName, int seatsRequested) {
     System.out.println(userName + " is trying to book " + seatsRequested + " seat(s).");

     try {
         Thread.sleep(1000); // Simulate processing delay
     } catch (InterruptedException e) {
         System.out.println("Booking interrupted.");
     }

     if (seatsRequested <= availableSeats) {
         availableSeats -= seatsRequested;
         System.out.println("✅ " + userName + " successfully booked " + seatsRequested + " seat(s).");
     } else {
         System.out.println("❌ Sorry " + userName + ", not enough seats available.");
     }

     System.out.println("🎫 Remaining seats: " + availableSeats + "\n");
 }
}

//User class extends Thread
class User extends Thread {
 private TicketBookingSystem bookingSystem;
 private String userName;
 private int seatsToBook;

 public User(TicketBookingSystem system, String name, int seats) {
     this.bookingSystem = system;
     this.userName = name;
     this.seatsToBook = seats;
 }

 public void run() {
     bookingSystem.bookTicket(userName, seatsToBook);
 }
}

//Main class
public class TicketBookingSimulation {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     System.out.print("Enter total number of seats available: ");
     int totalSeats = scanner.nextInt();

     TicketBookingSystem bookingSystem = new TicketBookingSystem(totalSeats);

     System.out.print("Enter number of users trying to book tickets: ");
     int userCount = scanner.nextInt();

     User[] users = new User[userCount];

     for (int i = 0; i < userCount; i++) {
         System.out.print("Enter name of user " + (i + 1) + ": ");
         String name = scanner.next();

         System.out.print("Enter number of seats " + name + " wants to book: ");
         int seats = scanner.nextInt();

         users[i] = new User(bookingSystem, name, seats);
     }

     System.out.println("\n🔁 Starting ticket booking simulation...\n");

     // Start all threads
     for (User user : users) {
         user.start();
     }

     // Wait for all threads to finish
     for (User user : users) {
         try {
             user.join();
         } catch (InterruptedException e) {
             System.out.println("Thread interrupted.");
         }
     }

     System.out.println("✅ All bookings processed. Simulation complete.");
     scanner.close();
 }
}
