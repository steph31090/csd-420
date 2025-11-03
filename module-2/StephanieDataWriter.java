/*
Name: Stephanie Ramos
Date: November 2, 2025
Assignment: Module 2 Data File Program
Purpose: This program writes two arrays of random integers and doubles to a .dat file.
*/

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class StephanieDataWriter {
    
    public static void main(String[] args) {

        // Create Random object to generate random values
        Random rand = new Random();

        // Arrays to store 5 random integers and 5 random doubles
        int[] intArray = new int[5];
        double[] doubleArray = new double[5];

        // Populate both arrays with random values
        for (int i = 0; i < 5; i++) {
            intArray[i] = rand.nextInt(100);
            doubleArray[i] = rand.nextDouble() * 100;
        }

        // Write the arrays to a .dat file
        try (FileWriter fw = new FileWriter("Stephanie_datafile.dat", true)) {
            
            // Write integers
            for (int num : intArray) {
                fw.write(num + " ");
            }
            fw.write("\n");

            // Write doubles
            for (double num : doubleArray) {
                fw.write(num + " ");
            }
            fw.write("\n");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}
