package com.bupt.winterholiday;

/**
 * Leetcode206:反转链表
 * @author gy
 */
public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode p = head;
        ListNode pNext = head.next;
        while (p.next != null){
            p.next = pre;
            pre = p;
            p = pNext;
            pNext = pNext.next;
        }
        p.next = pre;
        return p;
    }
}
