package com.example.springboothelloworld.Service.DataStructure;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreeImpl implements  BinaryTree {
    private  Node root;

    public BinaryTreeImpl(Node root) {
        this.root = root;
    }

    public BinaryTreeImpl() {
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }

    @Override
    public int size() {
        System.out.println("二叉树的节点数："+size(root));
        return size(root);
    }
    private  int  size(Node root)
    {
        if (root==null) return 0;
        return this.size(root.getLeftChild())+this.size(root.getRightChild())+1;
    }

    @Override
    public int getHeight() {
        System.out.println("二叉树的高度是：");
        return getHeight(root);
    }
    private  int getHeight(Node root)
    {
        if (root==null) return  0;

        //获取左子树的高度
        int left=this.getHeight(root.getLeftChild());

        //获取右子树的高度
        int right=this.getHeight(root.getRightChild());
        //返回Max(左子树，右子树)+1
        return  left>=right?left+1:right+1;
    }

    @Override
    public Node findKey(int value) {
        return null;
    }

    @Override
    public void preOrderTraverse() {
        if (root!=null)
        {
            System.out.println("先序遍历：");
            preOrderTraverse(root);
        }
    }
    private void preOrderTraverse(Node root) {
        if (root!=null)
        {
            System.out.print(root.getValue()+" ");
            this.preOrderTraverse(root.getLeftChild());
            this.preOrderTraverse(root.getRightChild());
        }
    }
    @Override
    public void inOrderTraverse() {
        System.out.println("中序遍历：");
        inOrderTraverse(root);
    }
    private void inOrderTraverse(Node root) {
        if (root!=null)
        {
            this.inOrderTraverse(root.getLeftChild());
            System.out.print(root.getValue()+" ");
            this.inOrderTraverse(root.getRightChild());
        }
    }
    @Override
    public void postOrderTraverse() {
        System.out.println("后序遍历：");
        postOrderTraverse2(root);
    }
    private void postOrderTraverse2(Node root) {
        if (root!=null)
        {
            this.postOrderTraverse2(root.getLeftChild());
            this.postOrderTraverse2(root.getRightChild());
            System.out.print(root.getValue()+" ");
        }
    }

    @Override
    public void postOrderTraverse(Node node) {

    }

    @Override
    public void preOrderByStack() {


    }

    @Override
    public void inOrderByStack() {
        Deque<Node> stack= new LinkedList<Node>();
        Node current=root;
        while(current!=null||!stack.isEmpty())
        {
            while (current!=null)
            {
                stack.push(current);
                current=current.getLeftChild();
            }
            if (!stack.isEmpty())
            {
                current=stack.pop();
                System.out.println(current.getValue());
                current=current.getRightChild();
            }
        }
    }

    @Override
    public void postOrderByStack() {

    }

    @Override
    public void levelOrderByStack() {

    }
}
