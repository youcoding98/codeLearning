package com.bupt.signin;

/**
 * Leetcode147:对链表进行插入排序
 * @author Administrator
 */
public class signIn1120 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode lastSorted = head;
        ListNode curr = head.next;
        while (curr != null){
            if (lastSorted.val <= curr.val){
                lastSorted = lastSorted.next;
            }else{
                ListNode temp = newHead;
                while (temp.next.val <= curr.val){
                    temp = temp.next;
                }
                lastSorted.next = curr.next;
                curr.next = temp.next;
                temp.next = curr;
            }
            curr = lastSorted.next;
        }

        return newHead.next;
    }
}
