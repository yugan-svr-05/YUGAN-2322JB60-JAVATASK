package day06;

//Class that implements Runnable
public class MessagePrinter implements Runnable {
 private String message;

 // Constructor to set the message for each thread
 public MessagePrinter(String message) {
     this.message = message;
 }

 // The run() method is executed when the thread starts
 public void run() {
     for (int i = 1; i <= 5; i++) {
         System.out.println(Thread.currentThread().getName() + ": " + message + " (" + i + ")");
         try {
             Thread.sleep(300); // Optional delay for readability
         } catch (InterruptedException e) {
             System.out.println("Thread interrupted");
         }
     }
 }

 // Main method to start multiple threads
 public static void main(String[] args) {
     // Create Runnable instances with different messages
     MessagePrinter printer1 = new MessagePrinter("Hello from Thread 1");
     MessagePrinter printer2 = new MessagePrinter("Hello from Thread 2");

     // Wrap Runnable instances in Thread objects
     Thread thread1 = new Thread(printer1, "Thread-1");
     Thread thread2 = new Thread(printer2, "Thread-2");

     // Start both threads
     thread1.start();
     thread2.start();
 }
}

