package com.bupt.leetcode.list;

/**
 * Leetcode206:反转链表
 * @author Administrator
 */
public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode p = head;
        ListNode pNext = p.next;
        while (p.next != null){
            p.next = pre;
            pre = p;
            p = pNext;
            pNext = p.next;
        }
        p.next = pre;
        return p;
    }
}
