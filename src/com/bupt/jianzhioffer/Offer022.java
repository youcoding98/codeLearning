package com.bupt.jianzhioffer;

/**
 * Offer022:链表中倒数第K个节点
 * @author Administrator
 */
public class Offer022 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (k == 0 || head == null){
            return null;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        ListNode q = newHead;
        while (k > 0){
            q = q.next;
            k--;
        }
        while (q != null){
            q = q.next;
            p = p.next;
        }
        return p;
    }
}
