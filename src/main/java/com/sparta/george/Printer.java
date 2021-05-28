package com.sparta.george;

public class Printer {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void printArray(int[] arrayToPrint, boolean sorted) {
        if (arrayToPrint.length == 0){
            return;
        }
        if (sorted){
            System.out.println(ANSI_GREEN + "Sorted Array: ");
        }else{
            System.out.println(ANSI_RED + "Unsorted Array: ");
        }
        String arrayAsString = "";
        for (int number: arrayToPrint){
            arrayAsString += number + ", ";
        }
//        Substring used to remove tailing comma
        System.out.println(arrayAsString.substring(0, arrayAsString.length() - 2) + "\n");
    }
}
