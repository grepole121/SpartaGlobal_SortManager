package com.sparta.george.start;

import com.sparta.george.customExceptions.ChildNotFoundException;
import com.sparta.george.sorters.Sorter;
import com.sparta.george.sorters.SorterFactory;
import com.sparta.george.customExceptions.SorterNotFoundException;
import com.sparta.george.utility.UserChoice;
import com.sparta.george.utility.GetNumbers;
import com.sparta.george.utility.Printer;


public class Starter {
    public static void start() throws ChildNotFoundException, SorterNotFoundException {

//        int[] numbers = {2, 78, 3, 6, 21, 8, 452, 12, 3};
//        int[] numbers = {2, 3, 3, 6, 8, 12, 21, 78, 452};
//        Starter.sort(numbers, Starter.SortTypes.BUBBLE);
//        int[] numbers = GetNumbers.getRandomNumbers(100, 0, 100);
//        double[] times = GetTimes.getAllTimes(numbers);
//        Printer.printArray(times);
//        int[] numbers = Starter.getNumbers();
        UserChoice.chooseInput();
//        Starter.chooseSorter(numbers);


    }

    public static void sort(int[] numbers, SortTypes sorterType) {
        SorterFactory sorterFactory = new SorterFactory();
        Sorter sorter = sorterFactory.getSorter(sorterType);
        Printer.printArray(numbers, false);
        Printer.printArray(sorter.sortArray(numbers), true);
    }

    public static int[] getNumbers() {
        int[] numbers = GetNumbers.getNumbers();
        if (numbers.length == 0) {
            numbers = getNumbers();
        }
        return numbers;
    }

    public enum SortTypes {
        BUBBLE, MERGE, TREE
    }
}
