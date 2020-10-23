package com.bupt.signin;

/**
 * Leetcode234：回文链表
 * @author Administrator
 */
public class signIn1023 {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode middle = middleList(head);
        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;
        ListNode newRight = reverseList(right);
        while (newRight != null && left != null){
            if(left.val != newRight.val){
                return false;
            }
            newRight = newRight.next;
            left = left.next;
        }
        return true;
    }

    public ListNode middleList(ListNode head){
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode slow = newHead;
        ListNode fast = newHead;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head){
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
