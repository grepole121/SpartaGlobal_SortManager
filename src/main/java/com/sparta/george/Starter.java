package com.sparta.george;

import com.sparta.george.binaryTree.BinaryTreeImplementation;
import com.sparta.george.binaryTree.ChildNotFoundException;
import com.sparta.george.sorters.*;
import com.sparta.george.utility.Choose;
import com.sparta.george.utility.GetNumbers;
import com.sparta.george.utility.GetTimes;
import com.sparta.george.utility.Printer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Starter {
    public enum SortTypes {
        BUBBLE, MERGE, TREE
    }

    // TODO: 28/05/2021
    //  Complete performance tester
    //  Add logger where exceptions happen

    public static void start() throws ChildNotFoundException, SorterNotFoundException {

//        int[] numbers = {2, 78, 3, 6, 21, 8, 452, 12, 3};
//        int[] numbers = {2, 3, 3, 6, 8, 12, 21, 78, 452};
//        Starter.sort(numbers, Starter.SortTypes.BUBBLE);
//        int[] numbers = GetNumbers.getRandomNumbers(100, 0, 100);
//        double[] times = GetTimes.getAllTimes(numbers);
//        Printer.printArray(times);
//        int[] numbers = Starter.getNumbers();
        Choose.chooseInput();
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




    private static void binaryTree() throws ChildNotFoundException {
            /*
            Example binary tree
                 20
                / \
               /   \
              15    \
             / \     30
            4  17    / \
                    23  \
                         35
                         / \
                        32  50
         */
        System.out.print(Printer.ANSI_RESET);
        BinaryTreeImplementation bt = new BinaryTreeImplementation();
        bt.addElements(new int[]{15, 4});
        Printer.printArray(bt.getSortedTreeAsc());
        System.out.println(bt.getNumberOfElements());
    }
}
