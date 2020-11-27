package com.bupt.leetcode.stack;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

/**
 * Leetcode503；下一个更大元素II
 * @author Administrator
 */
public class Leetcode503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        int len = nums.length;
        Arrays.fill(result,-1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len * 2; i++) {
            int num = nums[i % len];
            while (!stack.isEmpty() && num > nums[stack.peek()]){
                result[stack.pop()] = num;
            }
            if (i < len){
                stack.push(i);
            }
        }

        return result;
    }
}
