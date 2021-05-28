package com.sparta.george;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sparta.george.binaryTree.BinaryTreeImplementation;
import com.sparta.george.binaryTree.ChildNotFoundException;
import com.sparta.george.sorters.BubbleSort;
import com.sparta.george.sorters.MergeSort;
import com.sparta.george.utility.GetNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class AppTest {
    @Test
    @DisplayName("The test compares sorted array with bubblesort result array")
    public void testBubbleSortingNumbers() {
        BubbleSort bs = new BubbleSort();
        int[] numbers = {2, 78, 3, 6, 21, 8, 452, 12, 3};
        int[] sortedNumbers = {2, 3, 3, 6, 8, 12, 21, 78, 452};
        Assertions.assertArrayEquals(sortedNumbers, bs.sortArray(numbers));
    }

    @Test
    @DisplayName("The test compares sorted array with mergesort result array")
    public void testMergeSortingNumbers() {
        MergeSort ms = new MergeSort();
        int[] numbers = {2, 78, 3, 6, 21, 8, 452, 12, 3};
        int[] sortedNumbers = {2, 3, 3, 6, 8, 12, 21, 78, 452};
        Assertions.assertArrayEquals(sortedNumbers, ms.sortArray(numbers));
    }

    @Test
    @DisplayName("The test checks if non-numeric character is inputted to getNumbers method")
    public void shouldReturnEmptyArray() {
        String simulatedUserInput = "t";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(in);

        Assertions.assertArrayEquals(new int[]{}, GetNumbers.getNumbers());
//        Assertions.assertThrows(InputMismatchException.class, GetNumbers::getNumbers);

    }


    @Test
    @DisplayName("The test checks if numeric characters are inputted to getNumbers method")
    public void shouldReturnArrayOfInts() {
        String simulatedUserInput = "4" + System.getProperty("line.separator")
                + "8" + System.getProperty("line.separator")
                + "2" + System.getProperty("line.separator")
                + "13" + System.getProperty("line.separator")
                + "5" + System.getProperty("line.separator");

        ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(in);

        Assertions.assertArrayEquals(new int[]{8, 2, 13, 5},GetNumbers.getNumbers());
    }


    @Test
    @DisplayName("This tests getRootElement")
    public void shouldGetRootElement() {
        BinaryTreeImplementation bt = new BinaryTreeImplementation(5);
        Assertions.assertEquals(5, bt.getRootElement());
    }

    @Test
    @DisplayName("This tests getting number of elements for single element")
    public void shouldReturnOne() {
        BinaryTreeImplementation bt = new BinaryTreeImplementation(5);
        Assertions.assertEquals(1, bt.getNumberOfElements());
    }

    @Test
    @DisplayName("This tests adding a node")
    public void shouldAddNode() throws ChildNotFoundException {
        BinaryTreeImplementation bt = new BinaryTreeImplementation(5);
        bt.addElement(4);
        bt.addElement(10);
        Assertions.assertEquals(3, bt.getNumberOfElements());
        Assertions.assertEquals(4, bt.getLeftChild(5));
    }

    @Test
    @DisplayName("This tests finding a value that exists")
    public void shouldFindValueAndReturnTrue() {
        BinaryTreeImplementation bt = new BinaryTreeImplementation(5);
        bt.addElements(new int[]{2, 8, 3});
        assertTrue(bt.findElement(8));
    }

    @Test
    @DisplayName("This tests finding a value that doesn't exist")
    public void shouldNotFindValueAndReturnFalse() {
        BinaryTreeImplementation bt = new BinaryTreeImplementation(5);
        bt.addElement(4);
        bt.addElement(10);
        Assertions.assertFalse(bt.findElement(12));
    }

    @Test
    @DisplayName("This test get left child of root")
    public void shouldFindLeftChild() throws ChildNotFoundException {
        BinaryTreeImplementation bt = new BinaryTreeImplementation(5);
        bt.addElements(new int[]{2, 8, 3});
        Assertions.assertEquals(2, bt.getLeftChild(5));
    }

    @Test
    @DisplayName("This test get left child of of child element")
    public void shouldFindLeftChildOfChild() throws ChildNotFoundException {
        BinaryTreeImplementation bt = new BinaryTreeImplementation(5);
        bt.addElements(new int[]{2, 1, 8, 3});
        Assertions.assertEquals(1, bt.getLeftChild(2));
    }

    @Test
    @DisplayName("This test get right child of of child element")
    public void shouldFindRightChildOfChild() throws ChildNotFoundException {
        BinaryTreeImplementation bt = new BinaryTreeImplementation(5);
        bt.addElements(new int[]{15, 4, 17, 30, 23, 35, 32, 50});
        Assertions.assertEquals(35, bt.getRightChild(30));
    }

    @Test
    @DisplayName("This test checks the sorted tree array")
    public void shouldHaveSortedTreeAsc() {
        BinaryTreeImplementation bt = new BinaryTreeImplementation(20);
        bt.addElements(new int[]{15, 4, 17, 30, 23, 35, 32, 50});
        Assertions.assertArrayEquals(new int[]{4, 15, 17, 20, 23, 30, 32, 35, 50}, bt.getSortedTreeAsc());
    }

    @Test
    @DisplayName("This test checks the sorted tree array")
    public void shouldHaveSortedTreeDesc() {
        BinaryTreeImplementation bt = new BinaryTreeImplementation(20);
        bt.addElements(new int[]{15, 4, 17, 30, 23, 35, 32, 50});
        Assertions.assertArrayEquals(new int[]{50, 35, 32, 30, 23, 20, 17, 15, 4}, bt.getSortedTreeDesc());
    }



}
