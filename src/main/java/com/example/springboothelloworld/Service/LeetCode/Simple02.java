package com.example.springboothelloworld.Service.LeetCode;

public class Simple02 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addNode(2);
        myLinkedList.addNode(3);
        myLinkedList.addNode(4);
        myLinkedList.printLink();
        myLinkedList.deleteNode(1);
        myLinkedList.printLink();
        myLinkedList.addNode(2);
        myLinkedList.printLink();
        myLinkedList.deleteNode(2);
        myLinkedList.printLink();

    }
}

class MyLinkedList {
    /**
     * 添加结点
     */

    ListNode head = null;

    public void addNode(int data) {

        ListNode newNode = new ListNode(data);
        //如果是头结点
        if (head == null) {
            head = newNode;
            return;
        }

        ListNode tmp = head;
        //找最后一个结点
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    /**
     * 求链表长度
     */
    public int length() {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 删除链表中的结点
     */
    public boolean deleteNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }
        //删除头节点
        if (index == 1) {
            head = head.next;
            return true;
        }
        ListNode preNode = head;
        ListNode curNode = preNode.next;
        int i = 1;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = preNode.next;
            curNode = curNode.next;
            i++;
        }
        return true;
    }

    /**
     * 打印结点
     */
    public void printLink() {
        ListNode curNode = head;
        while (curNode != null) {
            System.out.print(curNode.val + " ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, cur = head;
        int x = 0, y = 0, carry = 0;
        while (p != null || q != null) {
            x = p != null ? p.val : 0;
            y = q != null ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur=cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return  head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}