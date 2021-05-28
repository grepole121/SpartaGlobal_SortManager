package com.sparta.george;

import com.sparta.george.binaryTree.BinaryTreeImplementation;
import com.sparta.george.binaryTree.ChildNotFoundException;
import com.sparta.george.sorters.BubbleSort;
import com.sparta.george.sorters.MergeSort;

public class Starter {
    public static void start() throws ChildNotFoundException {
//        int[] numbers = {2, 78, 3, 6, 21, 8, 452, 12, 3};

//        int[] numbers = GetNumbers.getNumbers();
//        if (numbers.length == 0){
//            start();
//        }

//        Starter.bubbleSort(numbers);
//        Starter.mergeSort(numbers);
        Starter.binaryTree();
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

        BinaryTreeImplementation bt = new BinaryTreeImplementation(20);
        bt.addElements(new int[]{15, 4, 17, 30, 23, 35, 32, 50});
        System.out.println(bt.getNumberOfElements());
        System.out.println("Expect 15 --- Actual:" + bt.getLeftChild(20)); //
        System.out.println("Expect 23 --- Actual:" + bt.getLeftChild(30)); //Expect 23
        System.out.println("Expect 4 --- Actual:" + bt.getLeftChild(15)); //Expect 4
        System.out.println("Expect 35 --- Actual:" + bt.getRightChild(30)); // Expect 35
        System.out.println("Expect 50 --- Actual:" + bt.getRightChild(bt.getRightChild(30))); //Expect 50 (right child of 35)
    }

    public static void bubbleSort(int[] numbers) {
        BubbleSort bubbleSort = new BubbleSort();
        Printer.printArray(numbers, false);
        Printer.printArray(bubbleSort.sortArray(numbers), true);
    }

    public static void mergeSort(int[] numbers) {
        MergeSort mergeSort = new MergeSort();
        Printer.printArray(numbers, false);
        Printer.printArray(mergeSort.sortArray(numbers), true);
    }

}
