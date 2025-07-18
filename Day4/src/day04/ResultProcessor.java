package day04;

import java.io.*;

public class ResultProcessor {
    public static void main(String[] args) {
        // Define input and output file paths
        String inputFile = "marks.txt";
        String outputFile = "results.txt";

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            // Read the header from input file (and ignore it)
            @SuppressWarnings("unused")
			String header = reader.readLine();

            // Write header for output file
            writer.write("StudentName,Total,Average\n");

            String line;

            // Read each line from the input file
            while ((line = reader.readLine()) != null) {
                // Split the line by comma
                String[] parts = line.split(",");

                // Skip if the line does not have enough data
                if (parts.length < 4) continue;

                String name = parts[0].trim();
                int total = 0;

                // Sum the marks
                for (int i = 1; i < parts.length; i++) {
                    try {
                        int mark = Integer.parseInt(parts[i].trim());
                        total += mark;
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format for student " + name);
                        total += 0;
                    }
                }

                // Calculate average
                double average = total / (double)(parts.length - 1);

                // Write result to output file
                writer.write(String.format("%s,%d,%.2f\n", name, total, average));
            }

            System.out.println("Processing complete. Results saved to " + outputFile);

        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        }
    }
}
