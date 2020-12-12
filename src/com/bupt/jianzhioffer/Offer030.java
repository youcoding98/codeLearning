package com.bupt.jianzhioffer;

/**
 * Offer030:包含min函数的栈
 * @author gy
 */
public class Offer030 {
    private Node head;
    public Offer030() {

    }

    public void push(int x) {
        if (head == null){
            head = new Node(x,x,null);
        }else {
            head = new Node(x,Math.min(head.min,x),head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int min() {
        return head.min;
    }
}

class Node{
    int val;
    int min;
    Node next;

    public Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}