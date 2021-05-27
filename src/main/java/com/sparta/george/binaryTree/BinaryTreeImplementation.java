package com.sparta.george.binaryTree;

public class BinaryTreeImplementation implements BinaryTree{

    Node root;
    private int numberOfElements;

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
        return new Node(4);
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
        if (element < root.value){
            root.left = new Node(element);
            numberOfElements++;
        }else if (element > root.value){
            root.right = new Node (element);
            numberOfElements++;
        }
    }

    @Override
    public void addElements(int[] elements) {
        int length = elements.length;
        for (int i = 0; i < length; i++) {
            numberOfElements++;
        }
    }

    @Override
    public boolean findElement(int value) {
        return false;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        if (root.value == element){
            return root.left.value;
        }
        return 0;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        return 0;
    }

    @Override
    public int[] getSortedTreeAsc() {
        return new int[0];
    }

    @Override
    public int[] getSortedTreeDesc() {
        return new int[0];
    }
}
