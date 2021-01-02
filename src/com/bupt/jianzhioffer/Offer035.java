package com.bupt.jianzhioffer;

import java.util.HashMap;

/**
 * Offer035:复杂链表的复制
 * @author gy
 */

class Node2 {
    int val;
    Node2 next;
    Node2 random;

    public Node2(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Offer035 {
    public Node2 copyRandomList(Node2 head) {
        if (head == null){
            return null;
        }
        Node2 cur = head;
        while (cur != null){
            Node2 copyNode = new Node2(cur.val);
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
        Node2 copyNode = head.next;
        Node2 copyCur = head.next;
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
