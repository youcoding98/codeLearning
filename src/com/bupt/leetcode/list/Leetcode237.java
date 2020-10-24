package com.bupt.leetcode.list;

/**
 * Leetcode237:删除链表中的节点
 * @author gy
 */
public class Leetcode237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
