package main.java.com.sparta.sort.manager;

import com.sparta.sort.manager.controller.SortManagerController;
import com.sparta.sort.manager.view.SortManagerView;

public class SortMain {
    public static void main(String[] args) {
        SortManagerView view = new SortManagerView();
        SortManagerController controller = new SortManagerController(view);

        controller.updateView();
    }
}
