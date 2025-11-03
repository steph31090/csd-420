/*
Name: Stephanie Ramos
Date: November 2, 2025
Assignment: Module 2 Data File Program
Purpose: This program reads and displays the contents of a .dat file containing arrays of integers and doubles.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StephanieDataReader {
    public static void main(String[] args) {
        
        // Read and display the contents of the .dat file
        try {
            File file = new File("Stephanie_datafile.dat");
            Scanner input = new Scanner(file);

            // Display each line from the file
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }

            // Close the scanner
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
