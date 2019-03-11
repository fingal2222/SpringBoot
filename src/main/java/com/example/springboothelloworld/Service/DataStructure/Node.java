package com.example.springboothelloworld.Service.DataStructure;

public class Node {
    private  Object value;
    private  Node leftChild;
    private  Node rightChild;


    public Node(Object value) {
        this.value = value;
    }

    public Node() {
    }

    public Node(Object value, Node leftChild, Node rightChild) {
        this.value = value;
        this.leftChild = leftChild;

        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }

    public Object getValue() {
        return value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }
}
