package com.sparta.george.binaryTree;

import com.sparta.george.Printer;
import com.sparta.george.Starter;
import com.sparta.george.sorters.BubbleSort;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeImplementation implements BinaryTree{
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
    private int numberOfElements;
    private boolean found = false;

    public BinaryTreeImplementation() {
        root = new Node(100);
    }

    public BinaryTreeImplementation(int value) {
        root = new Node(value);
        numberOfElements = 1;
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
            numberOfElements++;
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
        return root.value;
    }

    @Override
    public int getNumberOfElements() {
        return numberOfElements;
    }

    @Override
    public void addElement(int element) {
        addNodeElement(root, element);
    }

    @Override
    public void addElements(int[] elements) {
        int length = elements.length;
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

    private List<Integer> getEveryElement(Node currentNode, List<Integer> nodeValues){
        nodeValues.add(currentNode.value);
        if (currentNode.left != null){
            getEveryElement(currentNode.left, nodeValues);
        }
        if (currentNode.right != null){
            getEveryElement(currentNode.right, nodeValues);
        }
        return nodeValues;
    }

    @Override
    public int[] getSortedTreeAsc() {
        BubbleSort bs = new BubbleSort();
        List<Integer> nodeValues = new ArrayList<>();
        int[] unsortedTree = getEveryElement(root, nodeValues).stream().mapToInt(Integer::intValue).toArray();
        int[] sortedTree = bs.sortArray(unsortedTree);
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
