package com.bupt.leetcode.list;

/**
 * Leetcode061:旋转链表
 * @author Administrator
 */
public class Leetcode061 {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        if (head == null || k == 0 || head.next == null){
            return head;
        }
        ListNode node = head;
        while (node != null){
            len++;
            node = node.next;
        }
        if (len < k){
            k = k % len;
        }
        if (len == k || k == 0){
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        ListNode q = newHead;
        while (k > 0){
            q = q.next;
            k--;
        }
        while (q.next != null){
            p = p.next;
            q = q.next;
        }

        newHead.next = p.next;
        p.next = null;
        q.next = head;
        return newHead.next;
    }
}
