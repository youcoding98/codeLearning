package com.bupt.leetcode.heap;

import java.util.PriorityQueue;

/**
 * Leetcode313:超级丑数
 * @author Administrator
 */
public class Leetcode313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        long temp = 1;
        for (int i = 1; i < n; i++) {

            for (int num:primes) {
                priorityQueue.add(temp * num);
            }
            temp = priorityQueue.poll();
            while (!priorityQueue.isEmpty() && temp == priorityQueue.peek()){
                priorityQueue.poll();
            }
        }
        return (int)temp;
    }
}
