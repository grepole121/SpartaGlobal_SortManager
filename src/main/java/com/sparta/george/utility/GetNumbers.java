package com.sparta.george.utility;

import com.sparta.george.sorters.SorterNotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetNumbers {
    public static int[] getNumbers() {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("How many numbers would you like to sort? ");
            int length = sc.nextInt();
            int[] numbers = new int[length];

            for (int i = 0; i < length; i++) {
                System.out.println("Enter number " + (i + 1));
                numbers[i] = sc.nextInt();
            }
            return numbers;
        } catch (InputMismatchException e) {
            System.out.println("You must only input numbers!\n\n");
        }
        return new int[]{};
    }

    //    Overloading constructors if no lowerbound inputted take it as 0
    public static int[] getRandomNumbers(int length, int upperBound) {
        return getRandomNumbers(length, 0, upperBound);
    }

    public static int[] getRandomNumbers(int length, int lowerBound, int upperBound) {
        int[] randomNumbers = new int[length];
        for (int i = 0; i < length; i++) {
            int randomNumber = (int) Math.floor(Math.random() * (upperBound - lowerBound + 1) + lowerBound);
            randomNumbers[i] = randomNumber;
        }
        return randomNumbers;
    }

    public static int[] getRandomNumbers() {
//        Ask user input for amount of numbers and range
        int length = 100;
        int upperBound = 100;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("How many random numbers would you like to generate");
            length = sc.nextInt();
            System.out.println("Minimum number you would like to generate");
            int lowerBound = sc.nextInt();
            System.out.println("Maximum number you would like to generate");
            upperBound = sc.nextInt();
            return getRandomNumbers(length, lowerBound, upperBound);
        } catch (InputMismatchException e) {
            System.out.println("Only input numbers!\n");
        }
        System.out.println("Using random array of size 100 ranging from 0 to 100.\n");
        return getRandomNumbers(length, upperBound);
    }
}
