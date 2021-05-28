package com.sparta.george.binaryTreeTests;

import com.sparta.george.binaryTree.BinaryTreeImplementation;
import com.sparta.george.binaryTree.ChildNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class binaryTreeTest {
    @Test
    @DisplayName("This tests getRootElement")
    public void shouldGetRootElement() {
        BinaryTreeImplementation bt = new BinaryTreeImplementation(5);
        Assertions.assertEquals(5, bt.getRootElement());
    }

    @Test
    @DisplayName("This tests getRootElement with no root")
    public void shouldGetRootElementZero() {
        BinaryTreeImplementation bt = new BinaryTreeImplementation();
        Assertions.assertEquals(0, bt.getRootElement());
    }

    @Test
    @DisplayName("This tests initialising with no root then adding one")
    public void shouldGetNewRootElementFive() {
        BinaryTreeImplementation bt = new BinaryTreeImplementation();
        bt.addElement(5);
        Assertions.assertEquals(5, bt.getRootElement());
    }

    @Test
    @DisplayName("This tests getting number of elements for single element")
    public void shouldReturnOne() {
        BinaryTreeImplementation bt = new BinaryTreeImplementation(5);
        Assertions.assertEquals(1, bt.getNumberOfElements());
    }

    @Test
    @DisplayName("This tests getting number of elements for multiple elements")
    public void shouldReturnFour() {
        BinaryTreeImplementation bt = new BinaryTreeImplementation(5);
        bt.addElements(new int[]{2, 8, 3});
        Assertions.assertEquals(4, bt.getNumberOfElements());
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

    @Test
    @DisplayName("This test checks the sorted tree array when no root is declared initially")
    public void shouldHaveSortedTreeAscNoRootConstructor() {
        BinaryTreeImplementation bt = new BinaryTreeImplementation();
        bt.addElements(new int[]{15, 4, 17, 30, 23, 35, 32, 50, 20});
        Assertions.assertArrayEquals(new int[]{4, 15, 17, 20, 23, 30, 32, 35, 50}, bt.getSortedTreeAsc());
    }
}
