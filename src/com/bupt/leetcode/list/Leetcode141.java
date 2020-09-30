package com.bupt.leetcode.list;

/**
 * Leetcode141:环形链表
 * @author Administrator
 */
public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode p = head;
        ListNode q = head.next;
        while (p != q){
            if (q == null || q.next == null){
                return false;
            }
            p = p.next;
            q = q.next.next;
        }
        return true;
    }
}
