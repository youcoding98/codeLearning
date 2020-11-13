package com.bupt.leetcode.heap;

import java.util.PriorityQueue;

/**
 * Leetcode264:丑数II
 * @author Administrator
 */
public class Leetcode264 {
    private int[] uglyNums = {2,3,5};
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1L);
        int result = 0;
        while (n > 0){
            long temp = priorityQueue.poll();
            for (int num:uglyNums) {
                if (!priorityQueue.contains(temp * num)){
                    priorityQueue.add(temp * num);
                }
            }
            result = (int) temp;
            n--;
        }
        return result;
    }
}
