package com.sparta.george.utility;

public class SortedChecker {
    public static boolean isSorted(int[] arrayToCheck) {
        for (int i = 0; i < arrayToCheck.length - 1; i++) {
            if (arrayToCheck[i] > arrayToCheck[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
