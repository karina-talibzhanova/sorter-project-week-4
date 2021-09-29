package com.sparta.sort.manager.model;

import java.util.Arrays;

public class BubbleSort implements Sortable {
    public int[] sort(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        int n = sortedArr.length-1;
        int temp;

        // at each pass through, ignore the last correctly placed element
        while (n > 1) {
            for (int i = 0; i < n-1; i++) {
                if (sortedArr[i] > sortedArr[i+1]) {
                    temp = sortedArr[i];
                    sortedArr[i] = sortedArr[i+1];
                    sortedArr[i+1] = temp;
                }
            }
            n--;
        }
        return sortedArr;
    }
}
