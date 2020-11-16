package com.bupt.interview;

import java.util.PriorityQueue;

/**
 * 面试题17.09：第K个数
 * @author Administrator
 */
public class Q1709 {
    private int[] nums = {3,5,7};

    public int getKthMagicNumber(int k) {
        if (k == 1){
            return 1;
        }
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1L);
        long result = 0;
        while (k > 0){
            for (int num:nums) {
                if (!priorityQueue.contains(num * priorityQueue.peek())){
                    priorityQueue.add(num * priorityQueue.peek());
                }
            }
            result = priorityQueue.poll();
            k--;
        }
        return (int)result;

    }
}
