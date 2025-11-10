/**
 * Stephanie Ramos
 * Module 4 Programming Assignment
 * November 9, 2025
 *
 * This program compares the time it takes to traverse a LinkedList
 * using an iterator versus using get(index).
 */

/** Results: The iterator approach was noticeably faster than using get(index) for both 50,000 and 500,000 elements. 
 * With 50,000 elements, the iterator finished in just a few milliseconds, while get(index) took much longer. 
 * The difference became much more obvious at 500,000 elements, where the get(index) approach took a very long time to complete. 
 * This happens because an iterator moves through the list in order, while get(index) must repeatedly search through the 
 * LinkedList to find each element, making it slower as the list gets larger.
 */

import java.util.Iterator;
import java.util.LinkedList;

public class ListTimingTest {

    public static void main(String[] args) {

        int[] sizes = {50_000, 500_000};

        for (int n : sizes) {
            System.out.println("\n=== Test with n = " + n + " ===");

            LinkedList<Integer> list = buildLinkedList(n);

            long startIter = System.nanoTime();
            traverseWithIterator(list);
            long endIter = System.nanoTime();

            long startGet = System.nanoTime();
            traverseWithGet(list);
            long endGet = System.nanoTime();

            System.out.printf("Iterator time: %.3f ms%n", (endIter - startIter) / 1_000_000.0);
            System.out.printf("get(index) time: %.3f ms%n", (endGet - startGet) / 1_000_000.0);
        }
    }

    // Builds a LinkedList of integers from 0 to n-1
    private static LinkedList<Integer> buildLinkedList(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        return list;
    }

    // Traverses the list using an iterator
    private static void traverseWithIterator(LinkedList<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    // Traverses the list using get(index)
    private static void traverseWithGet(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
    }
}
