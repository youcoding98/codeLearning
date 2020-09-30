package com.bupt.leetcode.list;

import javax.swing.tree.TreeNode;

/**
 * Leetcode086:分隔链表
 * @author Administrator
 */
public class Leetcode086 {
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = head;
        ListNode q = newHead;
        while (p != null){
            if (p.val < x){
                ListNode temp = new ListNode(p.val);
                q.next = temp;
                q = temp;
            }
            p = p.next;
        }
        p = head;
        while (p != null){
            if (p.val >= x){
                ListNode temp = new ListNode(p.val);
                q.next = temp;
                q = temp;
            }
            p = p.next;
        }
        return newHead.next;
    }
}

