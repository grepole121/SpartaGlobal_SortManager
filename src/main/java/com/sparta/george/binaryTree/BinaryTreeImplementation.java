package com.sparta.george.binaryTree;

import com.sparta.george.sorters.Sorter;
import com.sparta.george.utility.Printer;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeImplementation implements BinaryTree, Sorter {
    /*
    Example binary tree
         20
        / \
       /   \
      15    \
     / \     30
    4  17    / \
            23  \
                 35
                 / \
                32  50
     */
    private Node root;
    private boolean found = false;

    public BinaryTreeImplementation() {
        Node root;
    }

    public BinaryTreeImplementation(int value) {
        root = new Node(value);
    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        long startTime = System.nanoTime();

        addElements(arrayToSort);
        int[] sortedTree = getSortedTreeAsc();

        long endTime = System.nanoTime();
        double timeTaken = endTime - startTime;
        if (arrayToSort.length != 0) {
            Printer.printTimeTaken(timeTaken, "Binary Tree");
        }
        return sortedTree;
    }

    public class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    private Node addNodeElement(Node currentNode, int value){
//        Recursive method to add nodes called by addElement
        if (currentNode == null){
            return new Node(value);
        }

        if (value < currentNode.value){
            currentNode.left = addNodeElement(currentNode.left, value);
        } else if (value > currentNode.value){
            currentNode.right = addNodeElement(currentNode.right, value);
        }

        return currentNode;
    }

    private void searchForNodeValues(Node currentNode, int value){
        if (currentNode != null){
            if (currentNode.value == value){
                found = true;
                return;
            }
            searchForNodeValues(currentNode.left, value);
            searchForNodeValues(currentNode.right, value);
        }
    }

    private int getChildren(Node currentNode, int value, boolean getLeft) throws ChildNotFoundException {
        try {
            if (currentNode.value == value) {
                if (getLeft) {
                    return currentNode.left.value;
                } else {
                    return currentNode.right.value;
                }
            } else if (currentNode.value > value) {
                return getChildren(currentNode.left, value, getLeft);
            } else {
                return getChildren(currentNode.right, value, getLeft);
            }
        }catch (NullPointerException e){
            throw new ChildNotFoundException("There is no child");
        }
    }

    @Override
    public int getRootElement() {
        if (root == null){
            return 0;
        }
        return root.value;
    }

    @Override
    public int getNumberOfElements() {
        return getSortedTreeAsc().length;
    }

    @Override
    public void addElement(int element) {
        if (root == null){
            root = new Node(element);
        }else {
            addNodeElement(root, element);
        }
    }

    @Override
    public void addElements(int[] elements) {
        for (int element: elements) {
            addElement(element);
        }
    }

    @Override
    public boolean findElement(int value) {
        searchForNodeValues(root, value);
        boolean elementExists = found;
        found = false;
        return elementExists;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        int childValue = 0;
        if (findElement(element)){
            childValue = getChildren(root, element, true);
        }else{
            System.out.println("Node with value " + element + " doesn't exist");
        }
        return childValue;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        int childValue = 0;
        if (findElement(element)){
            childValue = getChildren(root, element, false);
        }else{
            System.out.println("Node with value " + element + " doesn't exist");
        }
        return childValue;
    }
    //    =====================================================================

    private List<Integer> getSortedTree(Node currentNode, List<Integer> nodeValues){
        if (currentNode.left != null){
            getSortedTree(currentNode.left, nodeValues);
        }
        nodeValues.add(currentNode.value);
        if (currentNode.right != null){
            getSortedTree(currentNode.right, nodeValues);
        }
        return nodeValues;
    }

    @Override
    public int[] getSortedTreeAsc() {
        List<Integer> nodeValues = new ArrayList<>();
        int[] sortedTree = getSortedTree(root, nodeValues).stream().mapToInt(Integer::intValue).toArray();
        return sortedTree;
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] ascTree = getSortedTreeAsc();
        int[] descTree = new int[ascTree.length];
        for (int i = 0; i < ascTree.length; i++) {
            descTree[ascTree.length - i - 1] = ascTree[i];
        }
        return descTree;
    }
}
