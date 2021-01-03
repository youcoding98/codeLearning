package com.bupt.signin;

/**
 * Leetcode086:分隔链表
 * @author gy
 */
public class signIn0103 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newLowX = new ListNode(0);
        ListNode newHighX = new ListNode(0);
        ListNode l1 = newLowX;
        ListNode l2 = newHighX;
        while (head != null){
            if (head.val >= x){
                l2.next = head;
                head = head.next;
                l2 = l2.next;
                l2.next = null;
            }else {
                l1.next = head;
                head = head.next;
                l1 = l1.next;
                l1.next = null;
            }
        }
        l1.next = newHighX.next;
        return newLowX.next;
    }
}
