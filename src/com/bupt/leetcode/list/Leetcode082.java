package com.bupt.leetcode.list;

import java.util.HashSet;

/**
 * Leetcode082:删除排序链表中的重复元素II
 * @author Administrator
 */
public class Leetcode082 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        HashSet<Integer> set = new HashSet<>();
        while (node != null && node.next != null){
            if (node.val == node.next.val){
                set.add(node.val);
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        ListNode newHead = new ListNode(-1);
        ListNode newNode = newHead;
        node = head;
        while (node != null){
            if (!set.contains(node.val)){
                ListNode temp = new ListNode(node.val);
                newNode.next = temp;
                newNode = newNode.next;
            }
            node = node.next;
        }
        return newHead.next;
    }
}
