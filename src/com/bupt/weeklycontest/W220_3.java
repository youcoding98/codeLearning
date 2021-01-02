package com.bupt.weeklycontest;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 */
public class W220_3 {
    public static int maxResult(int[] nums, int k) {
        if (nums.length == 1){
            return nums[0];
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        //最大堆
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        heap.add(new int[]{dp[0],0});
        int[] peek = new int[2];
        for (int i = 1; i < nums.length; i++) {
            while (!heap.isEmpty()){
                peek = heap.peek();
                if (peek[1] + k < i){
                    heap.poll();
                }else {
                    break;
                }
            }
            dp[i] = peek[0] + nums[i];
            heap.add(new int[]{dp[i],i});
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1,-1,-2,4,-7,3};
        maxResult(nums,2);
    }
}
