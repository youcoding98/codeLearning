package com.bupt.leetcode.dp;

/**
 * Leetcode198:打家劫舍
 * @author Administrator
 */
public class Leetcode198 {
    public int rob(int[] nums) {
        int result = 0;
        if (nums == null || nums.length == 0){
            return result;
        }
        int n = nums.length;
        int[] dp = new int[n];
        if (n <= 2){
            if (n == 1){
                return nums[0];
            }else {
                return Math.max(nums[0],nums[1]);
            }
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
