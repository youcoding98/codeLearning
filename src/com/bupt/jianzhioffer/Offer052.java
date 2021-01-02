package com.bupt.jianzhioffer;

/**
 * Offer052:两个链表的第一个公共节点
 * @author Administrator
 */
public class Offer052 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2){
            if (l1 == null){
                l1 = headB;
            }else {
                l1 = l1.next;
            }
            if (l2 == null){
                l2 = headA;
            }else {
                l2 = l2.next;
            }
        }
        return l1;
    }
}
