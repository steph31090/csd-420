/**
 * Stephanie Ramos
 * Module 5 Programming Assignment
 *
 * This program reads words from a text file, removes duplicates,
 * and displays the words in ascending and descending order.
 * The file used is collection_of_words.txt.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SortingTest {

    /**
     * Reads the file and prints unique words in both orders.
     */
    public static void main(String[] args) {

        Set<String> words = new TreeSet<>();

        try {
            File file = new File("collection_of_words.txt");
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                words.add(input.next().toLowerCase());
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("In ascending order:");
        for (String w : words) {
            System.out.println(w);
        }

        System.out.println("\nIn descending order:");
        for (String w : ((TreeSet<String>) words).descendingSet()) {
            System.out.println(w);
        }

        System.out.println("\nThe test is complete.");
    }
}