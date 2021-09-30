package com.sparta.sort.manager.model;

import java.util.Arrays;

public class QuickSort implements Sortable{
    @Override
    public int[] sort(int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        return quickSort(arrCopy, 0, arr.length-1);
    }

    private int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);  // partitioning index

            quickSort(arr, low, p-1);  // left side of pivot
            quickSort(arr, p+1, high);  // right side of pivot
        }
        return arr;
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // choose the pivot arbitrarily, we will always choose element at high
        int pi = low-1;  // pivot index
        int temp;

        for (int i = low; i <= high; i++) {
            if (arr[i] <= pivot) {
                // pivot is not at this position
                // increment pivot index
                pi++;
                // swap current element with pivot
                temp = arr[i];
                arr[i] = arr[pi];
                arr[pi] = temp;
            }
        }

        return pi;
    }
}
