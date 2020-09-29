package com.bupt.leetcode.list;

/**
 * Leetcode083:删除排序链表中的重复元素
 * @author Administrator
 */
public class Leetcode083 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null &&node.next != null){
            if (node.next.val == node.val){
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        return head;
    }
}
