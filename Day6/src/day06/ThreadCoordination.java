package day06;

	// Class that extends Thread
	class MyThread extends Thread {
	    private String threadName;

	    MyThread(String name) {
	        this.threadName = name;
	    }

	    public void run() {
	        for (int i = 1; i <= 3; i++) {
	            System.out.println(threadName + " - Count: " + i);
	            try {
	                Thread.sleep(1000); // Sleep for 1 second
	            } catch (InterruptedException e) {
	                System.out.println(threadName + " interrupted.");
	            }
	        }
	        System.out.println(threadName + " finished.");
	    }
	}

	// Main class
	public class ThreadCoordination {
	    public static void main(String[] args) {
	        MyThread t1 = new MyThread("Thread A");
	        MyThread t2 = new MyThread("Thread B");

	        t1.start(); // Start Thread A

	        try {
	            // Main thread waits for t1 to finish before starting t2
	            t1.join();
	        } catch (InterruptedException e) {
	            System.out.println("Main thread interrupted.");
	        }

	        t2.start(); // Start Thread B after Thread A is complete

	        try {
	            t2.join(); // Optional: wait for t2 to finish
	        } catch (InterruptedException e) {
	            System.out.println("Main thread interrupted.");
	        }

	        System.out.println("Main thread finished.");
	    }
	}
