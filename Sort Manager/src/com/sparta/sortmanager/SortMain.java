package com.sparta.sortmanager;

import java.util.Scanner;

public class SortMain {
    public static void main(String[] args) {
        System.out.println("Select which sorting algorithm you would like - BubbleSort, MergeSort.");
        Scanner scan = new Scanner(System.in);
        String choice = scan.next();

        Sortable sorter = sortableFactory(choice);

        int[] unsorted = {2, 5, 2, 1, 7, 8};

        int[] sorted = sorter.sort(unsorted);
        for (int i : unsorted) {
            System.out.print(i + " ");
        }
        System.out.println("");
        for (int i : sorted) {
            System.out.print(i + " ");
        }
    }

    public static Sortable sortableFactory(String choice) {
        if (choice.equals("BubbleSort")) {
            return new BubbleSort();
        } else if (choice.equals("MergeSort")) {
            return new MergeSort();
        } else {
            return null;  // raise an exception here
        }
    }
}
