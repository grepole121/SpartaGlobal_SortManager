package com.sparta.george.sorters;

import com.sparta.george.utility.Printer;
import com.sparta.george.utility.SortedChecker;

public class BubbleSort implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {
        long startTime = System.nanoTime();

        if (!SortedChecker.isSorted(arrayToSort)) {
            boolean changed = true;
            for (int i = 0; i < arrayToSort.length - 1; i++) {
                if (!changed) {
                    break;
                }
                changed = false;
                for (int j = 0; j < arrayToSort.length - i - 1; j++) {
                    if (arrayToSort[j] > arrayToSort[j + 1]) {
                        int temp = arrayToSort[j];
                        arrayToSort[j] = arrayToSort[j + 1];
                        arrayToSort[j + 1] = temp;
                        changed = true;
                    }
                }
            }
        }

        long endTime = System.nanoTime();
        double timeTaken = endTime - startTime;
        if (arrayToSort.length != 0) {
            Printer.printTimeTaken(timeTaken, "Bubble");
        }
        return arrayToSort;
    }
}
