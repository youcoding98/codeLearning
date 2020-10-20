package com.bupt.signin;

/**
 * Leetcode143 :重排链表
 * @author Administrator
 */
public class signIn1020 {
    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }

        ListNode middle = middleNode(head);

        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;

        ListNode p = reverseList(right);

        ListNode q = left;

        while (q.next != null && p != null){
            ListNode qNext = q.next;
            ListNode pNext = p.next;

            q.next = p;
            p.next = qNext;

            q = qNext;
            p = pNext;
        }
    }
    public ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

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
