package com.bupt.jianzhioffer;


import java.util.ArrayList;
import java.util.List;

/**
 * Offer006:从尾到头打印链表
 * @author gy
 */
public class Offer006 {
    public int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[]{};
        }
        if (head.next == null){
            return new int[]{head.val};
        }
        ListNode pre = null;
        ListNode p = head;
        ListNode pNext = p.next;
        while (p.next != null){
            p.next = pre;
            pre = p;
            p = pNext;
            pNext = pNext.next;
        }
        p.next = pre;
        List<Integer> list = new ArrayList<>();
        while (p != null){
            list.add(p.val);
            p = p.next;
        }
        int[] result = new int[list.size()];
        int index = 0;
        for (int num:list) {
            result[index++] = num;
        }
        return result;
    }
}
