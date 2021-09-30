package com.sparta.sort.manager.test.model;

import com.sparta.sort.manager.model.MergeSort;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MergeSortShould {
    static MergeSort mergeSorter;
    @BeforeAll
    public static void setUp() {
        mergeSorter = new MergeSort();  // create BubbleSort object for all tests to use
    }
    @Test
    public void getUnsortedArrayOfUniqueIntegers_ReturnSortedArray() {
        int[] unsorted = {3, 4, 1, 2, 5};
        int[] sorted = {1, 2, 3, 4, 5};
        assertArrayEquals(sorted, mergeSorter.sort(unsorted));
    }

    @Test
    public void getUnsortedArrayOfNonUniqueIntegers_ReturnSortedArray() {
        int[] unsorted = {3, 3, 1, 4, 2, 1, 5};
        int[] sorted = {1, 1, 2, 3, 3, 4, 5};

        assertArrayEquals(sorted, mergeSorter.sort(unsorted));
    }

    @Test
    public void getArrayLengthOne_ReturnArrayLengthOne() {
        int[] target = {1};
        assertArrayEquals(target, mergeSorter.sort(target));
    }

    @Test
    public void getArrayLengthZero_ReturnArrayLengthZero() {
        int[] target = new int[0];
        assertArrayEquals(target, mergeSorter.sort(target));
    }

    @Test
    public void getArrayNegativeIntegers_ReturnSortedArray() {
        int[] unsorted = {-4, -1, -10, -3, -2};
        int[] sorted = {-10, -4, -3, -2, -1};

        assertArrayEquals(sorted, mergeSorter.sort(unsorted));
    }

    @Test
    public void getArrayMixedPositiveNegative_ReturnSortedArray() {
        int[] unsorted = {-4, 0, 34, -5, -100, 32, 0};
        int[] sorted = {-100, -5, -4, 0, 0, 32, 34};

        assertArrayEquals(sorted, mergeSorter.sort(unsorted));
    }
}
