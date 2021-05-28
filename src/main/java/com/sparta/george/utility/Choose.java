package com.sparta.george.utility;

import com.sparta.george.Starter;
import com.sparta.george.sorters.SorterNotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Choose {
    public static void chooseInput() {
        String wrongInput = "You can only enter a number between 1 and 2";
        System.out.print("Enter 1 for Random Numbers or 2 if you want to choose: ");
        Scanner sc = new Scanner(System.in);

        try {
            switch (sc.nextInt()) {
                case 1:
                    int[] randomNumbers = GetNumbers.getRandomNumbers();
                    Choose.chooseSorter(randomNumbers);
                    break;
                case 2:
                    int[] numbers = Starter.getNumbers();
                    Choose.chooseSorter(numbers);
                    break;
                default:
                    throw new SorterNotFoundException(wrongInput);
            }
        } catch (InputMismatchException | SorterNotFoundException e) {
            System.out.println(wrongInput);
        }

    }

    public static Starter.SortTypes chooseSorter(int[] numbers) throws SorterNotFoundException {
        String wrongInput = "You can only enter a number between 1 and 4";
        System.out.print("Enter 1 for BubbleSort, 2 for MergeSort, 3 for BinaryTree (removes duplicates), 4 for all: ");
        Scanner sc = new Scanner(System.in);
        try {
            switch (sc.nextInt()) {
                case 1:
                    Starter.sort(numbers, Starter.SortTypes.BUBBLE);
                    break;
                case 2:
                    Starter.sort(numbers, Starter.SortTypes.MERGE);
                    break;
                case 3:
                    Starter.sort(numbers, Starter.SortTypes.TREE);
                    break;
                case 4:
                    int[] numbers1 = numbers.clone();
                    int[] numbers2 = numbers.clone();
                    int[] numbers3 = numbers.clone();

                    Starter.sort(numbers, Starter.SortTypes.BUBBLE);
                    System.out.println("\n");

                    Starter.sort(numbers1, Starter.SortTypes.MERGE);
                    System.out.println("\n");

                    Starter.sort(numbers2, Starter.SortTypes.TREE);
                    System.out.println("\n");

                    double[] times = GetTimes.getAllTimes(numbers3);

                    System.out.println("Bubble Sort | Merge Sort | Binary Tree Sort");
//                    Giving wrong time for binary Tree sorter
                    System.out.println(times[0] + "ms    |  " + times[1] + "ms  |     " + times[2] + "ms    ");

                    break;
                default:
                    throw new SorterNotFoundException(wrongInput);
            }
        } catch (InputMismatchException e) {
            System.out.println(wrongInput);
        }
        return null;
    }
}
