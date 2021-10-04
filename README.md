# Sort Manager

## Purpose
To create a project that allows the user to select between 2 (or more) different sorting algorithms.  
The current algorithms that have been implemented are:
* BubbleSort
* MergeSort
* QuickSort

## Project Details
The project has been structured using the MVC pattern, where the model contains the sorting algorithms themselves,
the controller chooses the sorting algorithm based on input and update the view, and the view contains the input and output methods.

There is also a suite of unit tests that test the methods in the model and the controller. The view was not unit tested as it is difficult to test console input and output.
This lead to a 63% line coverage; a figure that could certainly be improved upon.

There is some exception handling concerning user input. When an invalid input is given (e.g. incorrect algorithm name, string instead of an integer), 
the user is told their input was invalid and prompted again for correct input. These exceptions are logged using log4j.

## Further work
This project could be extended by implementing further algorithms in the model. These include:
* Binary Tree (with In-Order, Pre-Order, and Post-Order traversals)
* Insertion Sort
* Selection Sort  
and possibly others.

There could also be work done in creating a GUI using JavaFX and allow the user to select multiple algorithms for comparison.

A further extension would be introducing generics and allow for any comparable type to be sorted.
