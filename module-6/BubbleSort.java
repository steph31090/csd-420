/*
 * Stephanie Ramos
 * Module 6 Programming Assignment
 * 
 * This program includes two generic bubble sort methods:
 * - Sort using Comparable
 * - Sort using Comparator
 * Includes test code to show both versions work.
 */

import java.util.Comparator;

public class BubbleSort {

    // Bubble sort using Comparable
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Bubble sort using Comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Print method
    public static <E> void printArray(E[] list) {
        System.out.print("{ ");
        for (E item : list) {
            System.out.print(item + " ");
        }
        System.out.println("}");
    }

    // Test code
    public static void main(String[] args) {

        // Test Comparable version
        Integer[] numbers = {5, 2, 8, 3, 1};
        System.out.println("Before Comparable sort:");
        printArray(numbers);

        bubbleSort(numbers);

        System.out.println("After Comparable sort:");
        printArray(numbers);

        // Test Comparator version
        String[] names = {"Maria", "Carlos", "Ana", "Luis"};
        System.out.println("\nBefore Comparator sort:");
        printArray(names);

        bubbleSort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        System.out.println("After Comparator sort:");
        printArray(names);
    }
}
