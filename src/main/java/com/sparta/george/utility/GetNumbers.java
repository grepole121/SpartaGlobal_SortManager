package com.sparta.george.utility;

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
}
