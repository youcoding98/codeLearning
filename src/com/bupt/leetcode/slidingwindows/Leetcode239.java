package com.bupt.leetcode.slidingwindows;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Leetcode239:滑动窗口最大值
 * @author Administrator
 */
public class Leetcode239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0){
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            //弹出队首元素
            if (i >= k && i - k == deque.getFirst()){
                deque.pollFirst();
            }
            //弹出队尾元素
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.add(i);
            if (i >= k - 1){
                list.add(nums[deque.peekFirst()]);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(maxSlidingWindow(nums,3));
    }
}
