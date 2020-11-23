package com.bupt.signin;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leetcode148:排序链表
 * @author Administrator
 */
public class signIn1121 {
    public ListNode sortList(ListNode head) {
        return sortList(head,null);
    }

    public ListNode sortList(ListNode head,ListNode tail){
        if (head == null){
            return head;
        }
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode leftHead = sortList(head,mid);
        ListNode rightHead = sortList(mid,tail);
        return merge(leftHead,rightHead);
    }

    public ListNode merge(ListNode leftHead,ListNode rightHead){
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        ListNode temp1 = leftHead;
        ListNode temp2 = rightHead;
        while (temp1 != null && temp2 != null){
            if (temp1.val < temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null){
            temp.next = temp1;
        }else if (temp2 != null){
            temp.next = temp2;
        }
        return newHead.next;
    }


}
