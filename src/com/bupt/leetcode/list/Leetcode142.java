package com.bupt.leetcode.list;

import java.util.HashSet;

/**
 * Leetcode142:环形链表II
 * @author Administrator
 */
public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null){
            if (set.contains(node)){
                return node;
            }
            set.add(node);
            node = node.next;
        }
        return null;
    }

}
