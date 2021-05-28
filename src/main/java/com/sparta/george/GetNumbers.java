package com.sparta.george;

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
        }catch(InputMismatchException e){
            System.out.println("You must only input numbers!\n\n");
        }
        return new int[]{};
    }
}
