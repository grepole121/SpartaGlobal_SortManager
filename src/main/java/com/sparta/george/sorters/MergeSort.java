package com.sparta.george.sorters;

public class MergeSort implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {
        MergeSort ms = new MergeSort();
        ms.mergeSort(arrayToSort, 0, arrayToSort.length - 1);

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
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arrayToMerge[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arrayToMerge[mid + 1 + j];

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arrayToMerge[k] = L[i];
                i++;
            } else {
                arrayToMerge[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arrayToMerge[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arrayToMerge[k] = R[j];
            j++;
            k++;
        }
    }
}
