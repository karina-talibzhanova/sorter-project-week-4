package com.sparta.sort.manager.controller;

import com.sparta.sort.manager.model.*;
import com.sparta.sort.manager.view.SortManagerView;

import java.util.Random;
import java.util.Scanner;

public class SortManagerController {
    private Sortable model;
    private SortManagerView view;

    public SortManagerController(SortManagerView view) {
        this.view = view;
    }

    public Sortable sortableFactory(String choice) {
        if (choice.equals("BubbleSort")) {
            return new BubbleSort();
        } else if (choice.equals("MergeSort")) {
            return new MergeSort();
        } else {
            return null;  // raise an exception here
        }
    }

    public int[] generateRandomArr(int length) {
        Random rand = new Random();
        int[] arr = new int[length];
        for(int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(100);
        }
        return arr;
    }

    public void updateView() {
        view.printSelectionMenu();
        Scanner scan = new Scanner(System.in);
        String algorithmChoice = scan.next();
        view.printArrayLengthSelection();
        int arrayLength = scan.nextInt();

        model = sortableFactory(algorithmChoice);
        int[] unsorted = generateRandomArr(arrayLength);

        long start = System.nanoTime();
        int[] sorted = model.sort(unsorted);
        long end = System.nanoTime();

        long timeElapsed = end - start;

        view.printUnsortedArray(unsorted);
        view.printSortedArray(sorted);
        view.printTimeTaken(algorithmChoice, timeElapsed);
    }

}
