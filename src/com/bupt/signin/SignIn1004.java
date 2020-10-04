package com.bupt.signin;

/**
 * Leetcode002:两数相加
 * @author Administrator
 */
public class SignIn1004 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        ListNode p = l1;
        ListNode q = l2;
        int a = 0;
        int b = 0;
        int c = 0;
        while (p != null || q != null){
            if (p != null){
                a = p.val;
            }else{
                a = 0;
            }
            if (q != null){
                b = q.val;
            }else {
                b = 0;
            }
            int key = (a + b + c) % 10;
            c = (a + b + c) / 10;
            ListNode node = new ListNode(key);
            temp.next = node;
            temp = temp.next;
            if (p != null){
                p = p.next;
            }
            if (q != null){
                q = q.next;
            }

        }
        if (c != 0){
            ListNode node = new ListNode(c);
            temp.next = node;
        }
        return head.next;
    }
}
