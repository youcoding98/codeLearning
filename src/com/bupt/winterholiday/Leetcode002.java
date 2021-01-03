package com.bupt.winterholiday;

/**
 * Leetcode002:两数相加
 * @author gy
 */
public class Leetcode002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode newHead = new ListNode(0);
        ListNode l = newHead;
        int cur = 0;
        while (l1 != null || l2 != null){
            int num1 = 0;
            int num2 = 0;
            if (l1 != null){
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                num2 = l2.val;
                l2 = l2.next;
            }
            int sum = num1 + num2 + cur;
            cur = sum / 10;
            l.next = new ListNode(sum % 10);
            l = l.next;
        }
        if (cur != 0){
            l.next = new ListNode(cur);
        }
        return newHead.next;
    }
}
