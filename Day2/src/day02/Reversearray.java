package day02;

public class Reversearray {

	    public static void main(String[] args) {
	        int[] numbers = {1, 2, 3, 4, 5};

	        System.out.println("Original Array Order:");
	        for (int num : numbers) {
	            System.out.print(num + " ");
	        }

	        System.out.println("\nArray in reverse order:");
	        for (int i = numbers.length - 1; i >= 0; i--) {
	            System.out.print(numbers[i] + " ");
	        }
	    }
	}
