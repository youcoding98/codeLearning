package com.bupt.interview;

/**
 * 面试题02.05：链表求和
 * @author Administrator
 */
public class Q0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        int nextNum = 0;
        while (l1 != null || l2 != null){
            int num1 = 0,num2 = 0;
            if (l1 != null){
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                num2 = l2.val;
                l2 = l2.next;
            }
            int sum = num1 + num2 + nextNum;
            int num = sum % 10;
            nextNum = sum / 10;
            ListNode temp = new ListNode(num);
            p.next = temp;
            p = p.next;
        }
        if (nextNum > 0){
            ListNode temp = new ListNode(nextNum);
            p.next = temp;
        }
        return newHead.next;
    }
}
