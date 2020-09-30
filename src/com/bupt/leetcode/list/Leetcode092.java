package com.bupt.leetcode.list;

/**
 * Leetcode092:反转链表II
 * @author Administrator
 */
public class Leetcode092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        ListNode q = newHead;
        while (m > 1){
            p = p.next;
            m--;
        }
        ListNode start = p;
        p = p.next;
        ListNode first = p;
        while (n > 0){
            q = q.next;
            n--;
        }
        ListNode end = q.next;
        ListNode pre = null;
        ListNode pNext = p.next;
        while (p.next != end){
            p.next = pre;
            pre = p;
            p = pNext;
            pNext = p.next;
        }
        p.next = pre;
        start.next = p;
        first.next = end;
        return newHead.next;
    }

}
