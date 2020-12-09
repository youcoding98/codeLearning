package com.bupt.leetcode.bitmanipulation;

/**
 * Leetcode136:只出现一次的数字
 * @author Administrator
 */
public class Leetcode136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
