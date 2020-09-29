package com.bupt.leetcode.list;

/**
 * Leetcode019:删除链表的倒数第N个节点
 * @author Administrator
 */
public class Leetcode019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        ListNode q = newHead;
        while (n > 0){
            q = q.next;
            n--;
        }
        while (q.next != null){
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return newHead.next;

    }
}
