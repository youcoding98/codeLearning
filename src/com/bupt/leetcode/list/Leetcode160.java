package com.bupt.leetcode.list;

/**
 * Leetcode160:相交链表
 * @author Administrator
 */
public class Leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode p = headA;

        while (p != null){
            ListNode q = headB;
            while (q != null){
                if (p == q && p.next == q.next){
                    return p;
                }
                q = q.next;
            }
            p = p.next;
        }
        return null;
    }
}
