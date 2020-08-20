package com.bupt.leetcode.dp;

/**
 * Leetcode053：最大子序和
 * @author Administrator
 */
public class Leetcode053 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0 || nums == null){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }

}
