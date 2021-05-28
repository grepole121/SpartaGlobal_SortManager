package com.sparta.george.sorters;

import com.sparta.george.utility.Printer;

public class MergeSort implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {
        MergeSort ms = new MergeSort();
        long startTime = System.nanoTime();

        ms.mergeSort(arrayToSort, 0, arrayToSort.length - 1);

        long endTime = System.nanoTime();
        double timeTaken = endTime - startTime;
        if (arrayToSort.length != 0) {
            Printer.printTimeTaken(timeTaken, "Merge");
        }
        return arrayToSort;
    }

    public void mergeSort(int[] arrayToSort, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

//            Left half of array
            mergeSort(arrayToSort, left, mid);
//            Right half of array
            mergeSort(arrayToSort, mid + 1, right);

            merge(arrayToSort, left, mid, right);
//            Printer.printArray(arrayToSort);
        }
    }


    public void merge(int[] arrayToMerge, int left, int mid, int right) {
        int leftIndex = mid - left + 1;
        int rightIndex = right - mid;

        int leftArray[] = new int[leftIndex];
        int rightArray[] = new int[rightIndex];

        for (int i = 0; i < leftIndex; ++i)
            leftArray[i] = arrayToMerge[left + i];
        for (int j = 0; j < rightIndex; ++j)
            rightArray[j] = arrayToMerge[mid + 1 + j];

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftIndex && j < rightIndex) {
            if (leftArray[i] <= rightArray[j]) {
                arrayToMerge[k] = leftArray[i];
                i++;
            } else {
                arrayToMerge[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftIndex) {
            arrayToMerge[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightIndex) {
            arrayToMerge[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
