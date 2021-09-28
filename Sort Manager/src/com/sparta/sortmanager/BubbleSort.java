package com.sparta.sortmanager;

public class BubbleSort implements Sorter{
    public void sort(int[] arr) {
        int n = arr.length-1;
        int temp;

        // at each pass through, ignore the last correctly placed element
        while (n > 1) {
            for (int i = 0; i < n-1; i++) {
                if (arr[i] > arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            n--;
        }
    }
}
