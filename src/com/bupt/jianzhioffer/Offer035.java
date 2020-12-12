package com.bupt.jianzhioffer;

import java.util.HashMap;

/**
 * Offer035:复杂链表的复制
 * @author gy
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Offer035 {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Node cur = head;
        while (cur != null){
            Node copyNode = new Node(cur.val);
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        Node copyNode = head.next;
        Node copyCur = head.next;
        while (cur != null){
            cur.next = cur.next.next;
            cur = cur.next;
            if (copyCur.next != null){
                copyCur.next = copyCur.next.next;
                copyCur = copyCur.next;
            }
        }
        return copyNode;
    }
}
