package com.bupt.leetcode.heap;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * Leetcode373:查找和最小的K对数字
 * @author Administrator
 */
public class Leetcode373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new LinkedList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (Math.min(len1 * len2,k) == 0){
            return list;
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]);
            }
        });

        for (int i = 0; i < len1; i++) {
            priorityQueue.offer(new int[]{i,0});
        }
        while (priorityQueue.size() > 0 && k > 0){
            int[] pair = priorityQueue.poll();
            if (pair[1] + 1 < len2){
                priorityQueue.offer(new int[]{pair[0],pair[1] + 1});
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[pair[0]]);
            temp.add(nums2[pair[1]]);
            list.add(temp);
            k--;
        }
        return list;
    }
}
