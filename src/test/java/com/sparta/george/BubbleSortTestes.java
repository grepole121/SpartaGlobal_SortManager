package com.sparta.george;

import com.sparta.george.sorters.BubbleSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BubbleSortTestes {
    @Test
    @DisplayName("The test compares sorted array with bubblesort result array")
    public void testBubbleSortingNumbers() {
        BubbleSort bs = new BubbleSort();
        int[] numbers = {2, 78, 3, 6, 21, 8, 452, 12, 3};
        int[] sortedNumbers = {2, 3, 3, 6, 8, 12, 21, 78, 452};
        Assertions.assertArrayEquals(sortedNumbers, bs.sortArray(numbers));
    }
}
