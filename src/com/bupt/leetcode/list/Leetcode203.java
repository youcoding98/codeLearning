package com.bupt.leetcode.list;

/**
 * Leetcode203:移除链表元素
 * @author Administrator
 */
public class Leetcode203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        while (p != null && p.next != null){
            if (p.next.val == val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }

        }
        return newHead.next;
    }
}
