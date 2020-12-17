package com.bupt.leetcode.dp;

/**
 * Leetcode121:买卖股票的最佳时机
 * @author Administrator
 */
public class Leetcode121 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2){
            return 0;
        }
        int minPrices = prices[0];
        int result = 0;
        for (int i = 1; i < len; i++) {
            result = Math.max(prices[i] - minPrices,result);
            minPrices = Math.min(minPrices,prices[i]);
        }
        return result;
    }
}
