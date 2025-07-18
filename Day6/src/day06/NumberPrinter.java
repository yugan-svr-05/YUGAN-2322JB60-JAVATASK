package day06;

	// Define a class that extends Thread
	public class NumberPrinter extends Thread {

	    // Override the run() method
	    public void run() {
	        for (int i = 1; i <= 10; i++) {
	            System.out.println("Number: " + i);
	            try {
	                Thread.sleep(500); // Pause for 500 milliseconds (optional)
	            } catch (InterruptedException e) {
	                System.out.println("Thread interrupted");
	            }
	        }
	    }

	    // Main method to start the thread
	    public static void main(String[] args) {
	        NumberPrinter thread = new NumberPrinter(); // Create thread object
	        thread.start(); // Start the thread (calls run() in a new thread)
	    }
	}
