package com.bupt.leetcode.heap;

import java.util.PriorityQueue;

/**
 * Leetcode703:数据流中的第K大元素
 * @author Administrator
 */
public class Leetcode703 {
    private final PriorityQueue<Integer> priorityQueue;
    private final int k;

    public Leetcode703(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue<>(k);
        for (int i:nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < k){
            priorityQueue.offer(val);
        }else if (priorityQueue.peek() < val){
            priorityQueue.poll();
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }
}
