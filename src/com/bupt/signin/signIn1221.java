package com.bupt.signin;

/**
 * Leetcode746:使用最小花费爬楼梯
 * @author Administrator
 */
public class signIn1221 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = cost[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i-1];
        }
        return Math.min(dp[len],dp[len - 1]);
    }
}
