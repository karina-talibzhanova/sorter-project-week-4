package com.sparta.sort.manager.test.controller;

import com.sparta.sort.manager.controller.SortManagerController;
import com.sparta.sort.manager.model.BubbleSort;
import com.sparta.sort.manager.model.MergeSort;
import com.sparta.sort.manager.model.QuickSort;
import com.sparta.sort.manager.view.SortManagerView;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SortManagerControllerShould {
    static SortManagerController controller;
    static SortManagerView view;
    static long seed;

    @BeforeAll
    static void setUp() {
        view = new SortManagerView();
        controller = new SortManagerController(view);
        seed = 123;
    }

    // test generator method with specific seed (need to find out what the values are)
    // test generator for array length - positive int, negative int, not an int, no value
    // test factory for each possible choice

    @Test
    public void givenOne_ReturnArrayLengthOne() {
        assertEquals(1, controller.generateRandomArr(1, seed).length);
    }

    @Test
    public void givenFive_ReturnArrayLengthFive() {
        assertEquals(5, controller.generateRandomArr(5, seed).length);
    }

    @Test
    public void given10_ReturnTargetArray() {
        int[] target = {82, 50, 76, 89, 95, 57, 34, 37, 85, 53};
        assertArrayEquals(target, controller.generateRandomArr(10, seed));
    }

    @Test
    public void givenNegativeInteger_ThrowIllegalArgumentException() {
        // not entirely sure why i need a lambda expression here, but it doesn't work otherwise
        // code found here: https://stackoverflow.com/a/31826781
        assertThrows(IllegalArgumentException.class, () -> controller.generateRandomArr(-1, seed));
    }

    @Test
    public void givenStringBubbleSort_ReturnBubbleSortObject() {
        String input = "BubbleSort";
        BubbleSort target = new BubbleSort();

        assertEquals(target.getClass(), controller.sortableFactory(input).getClass());
    }

    @Test
    public void givenStringMergeSort_ReturnMergeSortObject() {
        String input = "MergeSort";
        MergeSort target = new MergeSort();

        assertEquals(target.getClass(), controller.sortableFactory(input).getClass());
    }

    @Test
    public void givenStringQuickSort_ReturnQuickSortObject() {
        String input = "QuickSort";
        QuickSort target = new QuickSort();

        assertEquals(target.getClass(), controller.sortableFactory(input).getClass());
    }

    @Test
    public void givenStringNotFromOptions_ThrowIllegalArgumentException() {
        String input = "not a valid option";

        assertThrows(IllegalArgumentException.class, () -> controller.sortableFactory(input));
    }


    @Test
    public void givenNull_ThrowIllegalArgumentException() {
        String input = null;

        assertThrows(IllegalArgumentException.class, () -> controller.sortableFactory(input));
    }
}
