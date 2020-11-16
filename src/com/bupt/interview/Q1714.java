package com.bupt.interview;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 面试题17.14；最小K个数
 * @author Administrator
 */
public class Q1714 {
    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0){
            return new int[]{};
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }
}
