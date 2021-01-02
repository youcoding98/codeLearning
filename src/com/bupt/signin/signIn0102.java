package com.bupt.signin;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Leetcode239:滑动窗口最大值
 * @author gy
 */
public class signIn0102 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k){
            return new int[]{};
        }
        int len = nums.length;
        int[] result = new int[len - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            while (deque.size() != 0 && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);

            if (deque.peek() < i - k + 1) {
                deque.removeFirst();
            }
            if (i >= k - 1){
                result[j++] = nums[deque.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums,3);
    }
}
