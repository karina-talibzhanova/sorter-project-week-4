package com.sparta.sort.manager.model;

import java.util.Arrays;

public class MergeSort implements Sortable {
    public int[] sort(int[] arr) {
        arr = mergeSort(arr);
        return arr;
    }

    private int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int middle = arr.length / 2;

        // populate left and right
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        int[] leftSorted = mergeSort(left);
        int[] rightSorted = mergeSort(right);

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
