package com.bupt.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leetcode378:有序矩阵中第K小的元素
 * @author Administrator
 */
public class Leetcode378 {
    public int kthSmallest(int[][] matrix,int k){
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            priorityQueue.offer(new int[]{matrix[i][0],i,0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] nums = priorityQueue.poll();
            if (nums[2] != len - 1){
                priorityQueue.offer(new int[]{matrix[nums[1]][nums[2] + 1],nums[1],nums[2] + 1});
            }
        }
        return priorityQueue.poll()[0];
    }
}
