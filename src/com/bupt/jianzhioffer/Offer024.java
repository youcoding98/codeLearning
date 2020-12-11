package com.bupt.jianzhioffer;

/**
 * Offer024:反转链表
 * @author Administrator
 */
public class Offer024 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode p = head;
        ListNode pNext = p.next;
        while (pNext != null) {
            p.next = pre;
            pre = p;
            p = pNext;
            pNext = pNext.next;
        }
        p.next = pre;
        return p;
    }
}
