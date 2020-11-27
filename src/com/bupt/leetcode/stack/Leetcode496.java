package com.bupt.leetcode.stack;

import java.util.*;

/**
 * Leetcode496:下一个更大元素I
 * @author Administrator
 */
public class Leetcode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i],-1);
        }
        return result;
    }

}
