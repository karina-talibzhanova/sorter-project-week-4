package com.sparta.sortmanager;

import java.util.Scanner;

public class SortMain {
    public static void main(String[] args) {
        System.out.println("Select which sorting algorithm you would like - BubbleSort, MergeSort.");
        Scanner scan = new Scanner(System.in);
        String choice = scan.next();

        Sortable sorter = sortableFactory(choice);

        int[] unsorted = {2, 5, 2, 1, 7, 8};

        System.out.println("Unsorted array: ");
        for (int i : unsorted) {
            System.out.print(i + " ");
        }
        long start = System.nanoTime();
        int[] sorted = sorter.sort(unsorted);
        long end = System.nanoTime();
        long timeElapsed = end-start;

        System.out.println("\nSorted array: ");
        for (int i : sorted) {
            System.out.print(i + " ");
        }
        System.out.println("\nThe algorithm took " + timeElapsed + " nanoseconds.");
    }

    public static Sortable sortableFactory(String choice) {
        if (choice.equals("BubbleSort")) {
            System.out.println("You have chosen BubbleSort.");
            return new BubbleSort();
        } else if (choice.equals("MergeSort")) {
            System.out.println("You have chosen MergeSort.");
            return new MergeSort();
        } else {
            return null;  // raise an exception here
        }
    }
}
