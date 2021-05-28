package com.sparta.george.sorters;

import com.sparta.george.utility.Printer;

public class BubbleSort implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {
        long startTime = System.nanoTime();
        for (int i = 0; i < arrayToSort.length - 1; i++) {
            for (int j = 0; j < arrayToSort.length - i - 1; j++) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    int temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        if (arrayToSort.length != 0) {
            System.out.println(Printer.ANSI_GREEN +
                    "Using Bubble Sort  ---  Time taken to sort: " +
                    timeTaken + "ns = " + (double) timeTaken / 1000000 + "ms");
        }
        return arrayToSort;
    }
}
