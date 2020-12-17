package com.bupt.signin;

/**
 * Leetcode714:买卖股票的最佳时机含手续费
 * @author Administrator
 */
public class signIn1217 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        //动态规划状态;0为不持有股票，1为持有股票
        int[][] dp = new int[len][2];
        //初始状态
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        int max = Math.max(dp[0][0],dp[0][1]);
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
            max = Math.max(max,Math.max(dp[i][0],dp[i][1]));
        }
        return max;
    }
}
