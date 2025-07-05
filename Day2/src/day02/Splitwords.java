package day02;

public class Splitwords {

	    public static void main(String[] args) {
	        String sentence = "This is a sample sentence to split";
	        String[] words = sentence.split("\\s+");

	        System.out.println("The words in the sentence are:");
	        for (String word : words) {
	            System.out.println(word);
	        }
	    }
	}

	

