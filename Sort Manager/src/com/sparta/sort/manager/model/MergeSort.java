package com.sparta.sort.manager.model;

import java.util.Arrays;

public class MergeSort implements Sortable {
    public int[] sort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int middle = arr.length / 2;

        // populate left and right
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        int[] leftSorted = sort(left);
        int[] rightSorted = sort(right);

        return merge(leftSorted, rightSorted);

    }

    private int[] merge(int[] leftArr, int[] rightArr) {
        int[] result = new int[leftArr.length + rightArr.length];
        int i = 0; int l = 0; int r = 0;

        // the actual merging part
        while (l < leftArr.length && r < rightArr.length) {
            if (leftArr[l] < rightArr[r]) {
                result[i] = leftArr[l];
                l++;
            } else {
                result[i] = rightArr[r];
                r++;
            }
            i++;
        }

        // if there are leftover elements from either left/right array, add them to result array
        if (l < leftArr.length) {
            for (int k = l; k < leftArr.length; k++) {
                result[i] = leftArr[k];
                i++;
            }
        } else if (r < rightArr.length) {
            for (int k = r; k < rightArr.length; k++) {
                result[i] = rightArr[k];
                i++;
            }
        }

        return result;
    }
}