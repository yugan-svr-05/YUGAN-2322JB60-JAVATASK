package day06;

//File: BankApp.java
public class BankApp {

 public static void main(String[] args) {
     BankAccount account = new BankAccount(1000); // Shared account with initial balance

     // Create multiple users (threads)
     Thread user1 = new Thread(new Customer(account, 700), "Alice");
     Thread user2 = new Thread(new Customer(account, 500), "Bob");
     Thread user3 = new Thread(new Customer(account, 300), "Charlie");

     // Start threads
     user1.start();
     user2.start();
     user3.start();
 }
}

//Shared BankAccount class
class BankAccount {
 private int balance;

 public BankAccount(int initialBalance) {
     this.balance = initialBalance;
 }

 // Synchronized method to prevent overdrawing
 public synchronized void withdraw(String user, int amount) {
     System.out.println(user + " is attempting to withdraw $" + amount);
     try {
         Thread.sleep(1000); // Simulate transaction delay
     } catch (InterruptedException e) {
         System.out.println(user + "'s transaction was interrupted.");
     }

     if (amount <= balance) {
         balance -= amount;
         System.out.println("✅ " + user + " successfully withdrew $" + amount);
     } else {
         System.out.println("❌ " + user + " failed to withdraw $" + amount + " (Insufficient funds)");
     }

     System.out.println("💰 Current Balance after " + user + "'s transaction: $" + balance + "\n");
 }
}

//User class implements Runnable
class Customer implements Runnable {
 private BankAccount account;
 private int withdrawalAmount;

 public Customer(BankAccount account, int amount) {
     this.account = account;
     this.withdrawalAmount = amount;
 }

 public void run() {
     String threadName = Thread.currentThread().getName();
     account.withdraw(threadName, withdrawalAmount);
 }
}
