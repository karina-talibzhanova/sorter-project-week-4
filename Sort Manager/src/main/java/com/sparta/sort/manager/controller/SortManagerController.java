package com.sparta.sort.manager.controller;

import com.sparta.sort.manager.model.*;
import com.sparta.sort.manager.view.SortManagerView;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;

public class SortManagerController {
    private Sortable model;
    private SortManagerView view;
    private Date date = new Date();

    public SortManagerController(SortManagerView view) {
        this.view = view;
    }

    public Sortable sortableFactory(String choice) {
        if (choice == null) {
            throw new IllegalArgumentException();
        }
        switch (choice) {
            case "BubbleSort":
                return new BubbleSort();
            case "MergeSort":
                return new MergeSort();
            case "QuickSort":
                return new QuickSort();
            default:
                throw new IllegalArgumentException();  // raise an exception here
        }
    }

    public int[] generateRandomArr(int length, long seed){
        if (length < 0) {
            throw new IllegalArgumentException();
        }
        Random rand = new Random(seed);
        int[] arr = new int[length];
        for(int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(100);
        }
        return arr;
    }

    public void updateView() {
        String algorithmChoice;
        int[] unsorted;
        int arrayLength;
        while (true) {
            algorithmChoice = view.printSelectionMenu();
            try {
                model = sortableFactory(algorithmChoice);
                break;
            } catch (IllegalArgumentException iae) {
                view.printErrorMessage();
            }
        }

        while (true) {
            try {
                arrayLength = view.printArrayLengthSelection();
                unsorted = generateRandomArr(arrayLength, date.getTime());
                break;
            } catch (InputMismatchException | IllegalArgumentException e) {
                view.printErrorMessage();
            }
        }

        long start = System.nanoTime();
        int[] sorted = model.sort(unsorted);
        long end = System.nanoTime();

        long timeElapsed = end - start;

        view.printUnsortedArray(unsorted);
        view.printSortedArray(sorted);
        view.printTimeTaken(algorithmChoice, timeElapsed);
    }

}
