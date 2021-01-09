package com.bupt.signin;

/**
 * Leetcode123:买卖股票的最佳时机III
 * @author gy
 */
public class signIn0109 {
    private int len;
    public int maxProfit(int[] prices) {
        len = prices.length;
        return maxProfit(2,prices);
    }

    public int maxProfit(int k,int[] prices){
        if (len < 2 || k == 0){
            return 0;
        }
        if (k >= len /2){
            greedy(prices);
        }
        int[][][] dp = new int[len + 1][k + 1][2];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][1] = Integer.MIN_VALUE;
            }
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i-1]);
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i-1]);
            }
        }
        return dp[len][k][0];
    }

    public int greedy(int[] prices){
        if(prices.length < 2){
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1;i < prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        return dp[len-1][0];
    }
}
