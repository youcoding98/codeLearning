package com.bupt.leetcode.dp;

/**
 * Leetcode416：分割等和子集
 * @author Administrator
 */
public class Leetcode416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }
        int sum = 0;
        for (int i:nums) {
            sum += i;
        }
        if (sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];

        dp[0][0] = true;
        if (nums[0] == target){
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target ; j++) {
                dp[i][j] = dp[i-1][j];
                if (nums[i] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
            if (dp[i][target]){
                return true;
            }
        }
        return dp[nums.length-1][target];
    }
}
