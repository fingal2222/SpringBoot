package com.example.springboothelloworld.Service.DataStructure;

import java.util.Set;
import java.util.TreeSet;

public class TreeDemo {
    public static void main(String[] args) {
        Set st=new TreeSet();

        st.add(4);
        st.add(2);
        st.add(3);
        st.add(1);
        System.out.println(st);


        Node node5=new Node(5,null,null);
        Node node4=new Node(4,null,node5);
        Node node7=new Node(7,null,null);
        Node node6=new Node(6,null,node7);
        Node node3=new Node(3,null,null);
        Node node2=new Node(2,node3,node6);
        Node node1=new Node(1,node4,node2);
        BinaryTree btree=new BinaryTreeImpl(node1);
        System.out.println(btree.isEmpty());
        btree.preOrderTraverse();
        System.out.println();
        btree.inOrderTraverse();
        System.out.println();
        btree.postOrderTraverse();
        System.out.println();
        System.out.println(btree.getHeight());
        btree.size();
        btree.inOrderByStack();



    }
}
