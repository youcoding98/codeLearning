package com.bupt.signin;

/**
 * Leetcode328:奇偶链表
 * @author Administrator
 */
public class signIn1113 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead1 = new ListNode(0);
        ListNode newHead2 = new ListNode(0);
        ListNode even = head;
        ListNode odd = even.next;
        newHead1.next = head;
        newHead2.next = head.next;
        while (odd.next != null ){
            even.next = odd.next;
            even = even.next;
            if (even.next != null){
                odd.next = even.next;
                odd = odd.next;
            }else{
                odd.next = null;
            }
        }
        even.next = newHead2.next;
        return newHead1.next;
    }
}
