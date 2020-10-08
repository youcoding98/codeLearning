package com.bupt.leetcode.slidingwindows;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * Leetcode480:滑动窗口中位数
 * @author Administrator
 */
public class Leetcode480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        //需要删除的数的数量
        Map<Integer, Integer> cnt = new HashMap<>();
        Queue<Integer> low = new PriorityQueue<>((a, b) -> b.compareTo(a)); //大顶堆
        Queue<Integer> hi = new PriorityQueue<>(); //小顶堆

        int i = 0, n = nums.length, j = 0;
        double[] ans = new double[n - k + 1];
        for (; i < k; ++i) low.offer(nums[i]);

        for (int l = 0; l < k / 2; ++l) {
            hi.offer(low.poll());
        }

        while (true) {
            ans[j++] = (k % 2 == 1 ? low.peek() : ((double)low.peek() + (double)hi.peek()) * 0.5);

            if (i == n) break;
            int balance = 0;
            //如果删除数后对平衡的影响
            balance += (nums[i - k] <= low.peek() ? -1 : 1);
            //记录要删除的数的数量
            cnt.put(nums[i - k], cnt.getOrDefault(nums[i - k], 0) + 1);
            if (!low.isEmpty() && nums[i] <= low.peek()) {
                ++balance;
                low.offer(nums[i++]);
            }else {
                --balance;
                hi.offer(nums[i++]);
            }

            if (balance > 0) {
                --balance;
                hi.offer(low.poll());
            }else if (balance < 0) {
                ++balance;
                low.offer(hi.poll());
            }

            while(cnt.getOrDefault(low.peek(), 0) > 0) {
                int u = low.poll();
                cnt.put(u, cnt.get(u) - 1);
            }
            while(!hi.isEmpty() && cnt.getOrDefault(hi.peek(), 0) > 0) {
                int u = hi.poll();
                cnt.put(u, cnt.get(u) - 1);
            }
        }
        return ans;
    }
}
