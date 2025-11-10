/**
 * Stephanie Ramos
 * Module 3 Programming Assignment
 * November 9, 2025
 * 
 * This program creates an ArrayList of 50 random integers ranging from 1 to 20,
 * then uses a static method to return a new ArrayList with duplicates removed.
 */

import java.util.ArrayList;
import java.util.Random;

public class NoDuplicateList {

    public static void main(String[] args) {

        // Create an ArrayList and fill it with 50 random values 1–20
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1);
        }

        // Call the method to remove duplicates
        ArrayList<Integer> noDupList = removeDuplicates(originalList);

        // Display the lists
        System.out.println("List: " + originalList);
        System.out.println("List With No Duplicates: " + noDupList);
    }

    // This method returns a new ArrayList with duplicates removed
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        ArrayList<E> newList = new ArrayList<>();

        for (E element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }

        return newList;
    }
}
