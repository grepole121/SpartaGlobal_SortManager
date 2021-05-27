package com.sparta.george;

import com.sparta.george.sorters.BubbleSort;
import com.sparta.george.sorters.MergeSort;

public class Starter {
    public static void start() {
//        int[] numbers = {2, 78, 3, 6, 21, 8, 452, 12, 3};
        BubbleSort bubbleSort = new BubbleSort();
        MergeSort mergeSort = new MergeSort();

        int[] numbers = GetNumbers.getNumbers();
        if (numbers.length == 0){
            System.out.println("\n");
            start();
        }
//            int[] numbers = {2, 78, 3, 6, 21, 8, 452, 12, 3};
        Printer.printArray(numbers, false);

        Printer.printArray(bubbleSort.sortArray(numbers), true);
//            Printer.printArray(mergeSort.sortArray(numbers), true);



    }


}
