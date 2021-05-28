package com.sparta.george.sorterTests;

import com.sparta.george.sorters.MergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MergeSortTest {
    @Test
    @DisplayName("The test compares sorted array with mergesort result array")
    public void testMergeSortingNumbers() {
        MergeSort ms = new MergeSort();
        int[] numbers = {2, 78, 3, 6, 21, 8, 452, 12, 3};
        int[] sortedNumbers = {2, 3, 3, 6, 8, 12, 21, 78, 452};
        Assertions.assertArrayEquals(sortedNumbers, ms.sortArray(numbers));
    }
}
