package com.bupt.leetcode.dp;

/**
 * Leetcode123:买卖股票的最佳时机III
 * @author Administrator
 */
public class Leetcode123 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2){
            return 0;
        }
        int[] dp = new int[len];
        int maxProfit = 0;
        int minPrices = prices[0];
        for (int i = 0; i < len; i++) {
            maxProfit = Math.max(maxProfit,prices[i] - minPrices);
            minPrices = Math.min(minPrices,prices[i]);
            dp[i] = maxProfit;
        }
        int result = dp[len - 1];
        int maxPrices = prices[len - 1];
        maxProfit = 0;
        for (int i = len - 2; i > 0 ; i--) {
            maxProfit = Math.max(maxProfit,maxPrices - prices[i]);
            maxPrices = Math.max(maxPrices,prices[i]);
            dp[i] += maxProfit;
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
