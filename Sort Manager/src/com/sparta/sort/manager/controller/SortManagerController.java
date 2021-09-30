package com.sparta.sort.manager.controller;

import com.sparta.sort.manager.model.*;
import com.sparta.sort.manager.view.SortManagerView;

import java.util.Random;

public class SortManagerController {
    private Sortable model;
    private SortManagerView view;

    public SortManagerController(SortManagerView view) {
        this.view = view;
    }

    public Sortable sortableFactory(String choice) {
        switch (choice) {
            case "BubbleSort":
                return new BubbleSort();
            case "MergeSort":
                return new MergeSort();
            case "QuickSort":
                return new QuickSort();
            default:
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
        String algorithmChoice = view.printSelectionMenu();
        int arrayLength = view.printArrayLengthSelection();

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
