package com.sparta.sortmanager;

public class SortMain {
    public static void main(String[] args) {
        int[] unsorted = {2, 5, 2, 1, 7, 8};

        Sortable sorter = new MergeSort();

        int[] sorted = sorter.sort(unsorted);
        for (int i : unsorted) {
            System.out.print(i + " ");
        }
        System.out.println("");
        for (int i : sorted) {
            System.out.print(i + " ");
        }
    }
}
