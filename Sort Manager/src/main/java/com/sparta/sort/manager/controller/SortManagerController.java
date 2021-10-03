package com.sparta.sort.manager.controller;

import com.sparta.sort.manager.model.*;
import com.sparta.sort.manager.view.SortManagerView;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SortManagerController {
    private Sortable model;
    private SortManagerView view;
    private Date date = new Date();
    private Logger logger = Logger.getLogger("Sort Manager Logger");

    public SortManagerController(SortManagerView view) {
        this.view = view;
        PropertyConfigurator.configure("Sort Manager/log4j.properties");
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
                logger.error("User did not type in a valid algorithm");
                view.printErrorMessage();
            }
        }

        while (true) {
            try {
                arrayLength = view.printArrayLengthSelection();
                unsorted = generateRandomArr(arrayLength, date.getTime());
                break;
            } catch (InputMismatchException ime) {
                logger.error("User did not supply an integer for array length");
                view.printErrorMessage();
            } catch(IllegalArgumentException iae) {
                logger.error("Array length is less than 0");
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
