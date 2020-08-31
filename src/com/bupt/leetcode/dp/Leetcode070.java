package com.bupt.leetcode.dp;

/**
 * Leetcode070:爬楼梯
 * @author Administrator
 */
public class Leetcode070 {
    public int climbStairs(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        if (n >= 2){

            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }
}
