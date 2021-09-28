package com.sparta.sortmanager;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort implements Sorter{
    public void sort(int[] arr) {

    }

    private int[] mergeSort(int[] arr) {
        int middle = arr.length / 2;

        // populate left and right
        int[] left = Arrays.copyOfRange(arr, 0, middle-1);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length-1);

        int[] leftSorted = mergeSort(left);
        int[] rightSorted = mergeSort(right);

        return merge(leftSorted, rightSorted);
    }

    private Object[] merge(int[] leftArr, int[] rightArr) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0; int j = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] > rightArr[j]) {
                result.add(leftArr[i]);
                i++;
            } else {
                result.add(rightArr[j]);
                j++;
            }
        }

        if (i < leftArr.length) {
            for (int k = i; k < leftArr.length; k++) {
                result.add(leftArr[i]);
            }
        } else if (j < rightArr.length) {
            for (int k = j; k < rightArr.length; k++) {
                result.add(rightArr[j]);
            }
        }

        return result.toArray();
    }
}

//        def merge(left, right):
//        result = []
//
//        i = 0
//        j = 0
//
//        while True:
//        if left[i] > right[j]:
//        result.append(left[i])
//        i += 1
//        else:
//        result.append(right[j])
//        j += 1
//
//        if i >= len(left) or j >= len(right):
//        break
//
//        if i < len(left):
//        result.extend(left[i:])
//        elif j < len(right):
//        result.extend(right[j:])
//
//        return result
//
//
//        def hybrid_sort(arr):
//        if len(arr) <= 4:
//        return selection_sort(arr)
//
//        middle = len(arr) // 2
//
//        left = arr[:middle]
//        right = arr[middle:]
//
//        left_sorted = hybrid_sort(left)
//        right_sorted = hybrid_sort(right)
//
//        return merge(left_sorted, right_sorted)
//
