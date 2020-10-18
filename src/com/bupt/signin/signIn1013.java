package com.bupt.signin;

/**
 * Leetcode024:两两交换链表中的节点
 * @author Administrator
 */
public class signIn1013 {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        while (head != null && head.next != null){
            ListNode p = head;
            ListNode q = head.next;

            pre.next = q;
            p.next = q.next;
            q.next = p;

            pre = p;
            head = p.next;
        }
        return newHead.next;
    }
}
