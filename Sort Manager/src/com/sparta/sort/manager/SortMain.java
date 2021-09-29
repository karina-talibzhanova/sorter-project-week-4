package com.sparta.sort.manager;

import com.sparta.sort.manager.controller.SortManagerController;
import com.sparta.sort.manager.model.BubbleSort;
import com.sparta.sort.manager.model.MergeSort;
import com.sparta.sort.manager.model.Sortable;
import com.sparta.sort.manager.view.SortManagerView;

import java.util.Scanner;

public class SortMain {
    public static void main(String[] args) {
        SortManagerView view = new SortManagerView();
        SortManagerController controller = new SortManagerController(view);

        controller.updateView();
    }

    public static Sortable sortableFactory(String choice) {
        if (choice.equals("BubbleSort")) {
            System.out.println("You have chosen BubbleSort.");
            return new BubbleSort();
        } else if (choice.equals("MergeSort")) {
            System.out.println("You have chosen MergeSort.");
            return new MergeSort();
        } else {
            return null;  // raise an exception here
        }
    }
}
