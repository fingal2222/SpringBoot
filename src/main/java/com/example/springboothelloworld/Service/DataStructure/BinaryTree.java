package com.example.springboothelloworld.Service.DataStructure;


public interface BinaryTree {
    boolean isEmpty();

    int size();

    int getHeight();

    Node findKey(int value);

    void preOrderTraverse();

    void inOrderTraverse();

    void postOrderTraverse();

    void postOrderTraverse(Node node);

    void preOrderByStack();

    void inOrderByStack();

    void postOrderByStack();

    void levelOrderByStack();

}
