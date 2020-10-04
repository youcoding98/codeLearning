package com.bupt.leetcode.list;

/**
 * Leetcode143:重排链表
 * @author Administrator
 */
public class Leetcode143 {
    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }

        ListNode middle = middleNode(head);

        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;

        right = reverse(right);

        merge(left,right);
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

    public ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public void merge(ListNode left,ListNode right){
        ListNode leftTemp;
        ListNode rightTemp;
        while (left.next != null && right != null){
            leftTemp = left.next;
            rightTemp = right.next;

            left.next = right;
            right.next = leftTemp;

            left = leftTemp;
            right = rightTemp;
        }
    }
}
