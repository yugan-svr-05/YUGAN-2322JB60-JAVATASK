package day04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Stringline_by_line {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String fileName = "output.txt"; // Change to desired path if needed

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	            System.out.println("Enter lines to write to the file (type 'exit' to finish):");

	            while (true) {
	                String line = scanner.nextLine();
	                if (line.equalsIgnoreCase("exit")) {
	                    break;
	                }
	                writer.write(line);
	                writer.newLine(); // Move to next line
	            }

	            System.out.println("Lines written to " + fileName);
	        } catch (IOException e) {
	            System.out.println("An error occurred: " + e.getMessage());
	       
	            scanner.close();
	        }
	    }
}
