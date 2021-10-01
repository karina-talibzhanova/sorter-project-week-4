package com.sparta.sort.manager.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SortManagerView {
    private Scanner scan = new Scanner(System.in);
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

    public String printSelectionMenu() {
        System.out.println("Select which sorting algorithm you would like to use:");
        System.out.println("- BubbleSort");
        System.out.println("- MergeSort");
        System.out.println("- QuickSort");

        return scan.next();
    }

    public int printArrayLengthSelection() {
        System.out.println("Enter the size of the array you would like to sort:");

        if (scan.hasNextInt()) {
            return scan.nextInt();
        }
        else {
            scan.next();  // empty the buffer? not sure why this works
            throw new InputMismatchException();
        }
    }

    public void printErrorMessage() {
        System.out.println("Your previous input was invalid. Please try again.");
    }
}
