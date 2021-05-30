package com.sparta.george;

import com.sparta.george.binaryTree.BinaryTreeImplementation;
import com.sparta.george.sorters.BubbleSort;
import com.sparta.george.sorters.MergeSort;
import com.sparta.george.utility.GetNumbers;
import com.sparta.george.utility.GetTimes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PerformanceTester {
    @Test
    @DisplayName("Performance test with 1,000 numbers")
    public void performanceTest1000() {
        int[] numbers = GetNumbers.getRandomNumbers(1000, 0, 10000000, true);

        double[] times = GetTimes.getAllTimes(numbers);

        System.out.println("Performance Testing with " + numbers.length + " elements");
        System.out.println("Bubble Sort | Merge Sort | Binary Tree Sort");
        System.out.printf("%.4fms    | %.4fms   | %.4fms ", times[0], times[1], times[2]);
    }

    @Test
    @DisplayName("Performance test with 10,000 numbers")
    public void performanceTest10000() {
        int sizeOfTest = 10000;
        int[] numbers = GetNumbers.getRandomNumbers(sizeOfTest, 0, 10000000, true);
        while(numbers.length < sizeOfTest){
            numbers = GetNumbers.getRandomNumbers(sizeOfTest, 0, 10000000, true);
        }

        double[] times = GetTimes.getAllTimes(numbers);

        System.out.println("Performance Testing with " + numbers.length + " elements");
        System.out.println("Bubble Sort | Merge Sort | Binary Tree Sort");
        System.out.printf("%.4fms    | %.4fms   | %.4fms ", times[0], times[1], times[2]);
    }

    @Test
    @DisplayName("Performance test with 100,000 numbers")
    public void performanceTest100000() {
        int sizeOfTest = 100000;
        int[] numbers = GetNumbers.getRandomNumbers(sizeOfTest, 0, 1000000000, true);
        while(numbers.length < sizeOfTest){
            numbers = GetNumbers.getRandomNumbers(sizeOfTest, 0, 1000000000, true);
        }

        double[] times = GetTimes.getAllTimes(numbers);

        System.out.println("Performance Testing with " + numbers.length + " elements");
        System.out.println("Bubble Sort | Merge Sort | Binary Tree Sort");
        System.out.printf("%.4fms    | %.4fms   | %.4fms ", times[0], times[1], times[2]);
    }
}
