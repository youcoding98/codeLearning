package com.bupt.jianzhioffer;

/**
 * Offer018:删除链表的节点
 * @author Administrator
 */
public class Offer018 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        while (p.next != null){
            if (p.next.val == val){
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
        return newHead.next;
    }
}
