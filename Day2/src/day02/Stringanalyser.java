package day02;

import java.util.Scanner;

public class Stringanalyser {

	    public static int wordCount(String input) {
	        input = input.trim();
	        if (input.isEmpty()) {
	            return 0;
	        }
	        String[] words = input.split("\\s+");
	        return words.length;
	    }

	    public static int characterCount(String input) {
	        input = input.replace(" ", "");
	        return input.length();
	    }

	    public static String reverseString(String input) {
	        StringBuilder sb = new StringBuilder(input);
	        return sb.reverse().toString();
	    }

	    public static String longestWord(String input) {
	        String[] words = input.split("\\s+");
	        String longest = "";
	        for (String word : words) {
	            if (word.length() > longest.length()) {
	                longest = word;
	            }
	        }
	        return longest;
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter a string: ");
	        String input = scanner.nextLine();

	        System.out.println("Word Count: " + wordCount(input));
	        System.out.println("Character Count (excluding spaces): " + characterCount(input));
	        System.out.println("Reversed String: " + reverseString(input));
	        System.out.println("Longest Word: " + longestWord(input));

	        scanner.close();
	    }
	}
