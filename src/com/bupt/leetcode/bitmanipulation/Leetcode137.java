package com.bupt.leetcode.bitmanipulation;

/**
 * Leetcode137:只出现一次的数字II
 * @author Administrator
 */
public class Leetcode137 {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j] >> i) & 1;
            }
            result ^= (sum % 3) << i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        singleNumber(nums);
    }
}
