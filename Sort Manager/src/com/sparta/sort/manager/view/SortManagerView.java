package com.sparta.sort.manager.view;

public class SortManagerView {
    public void printUnsortedArray(int[] unsortedArr) {
        System.out.println("Unsorted array: ");
        for (int i : unsortedArr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public void printSortedArray(int[] sortedArr) {
        System.out.println("Sorted array: ");
        for (int i : sortedArr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public void printTimeTaken(String algorithmName, long timeTaken) {
        System.out.println("The " + algorithmName + " algorithm took " + timeTaken + " nanoseconds.");
    }

    public void printSelectionMenu() {
        System.out.println("Select which sorting algorithm you would like to use:");
        System.out.println("- BubbleSort");
        System.out.println("- MergeSort");
    }

    public void printArrayLengthSelection() {
        System.out.println("Enter the size of the array you would like to sort:");
    }
}
