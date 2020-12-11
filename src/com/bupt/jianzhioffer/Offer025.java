package com.bupt.jianzhioffer;

/**
 * Offer025:合并两个排序的链表
 * @author Administrator
 */
public class Offer025 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode newHead = new ListNode(0);
        ListNode node = newHead;
        ListNode p = l1;
        ListNode q = l2;
        while (p != null && q != null){
            if (p.val <= q.val){
                node.next = p;
                node = p;
                p = p.next;
            }else {
                node.next = q;
                node = q;
                q = q.next;
            }
        }
        if (p != null){
            node.next = p;
        }
        if (q != null){
            node.next = q;
        }
        return newHead.next;
    }
}
