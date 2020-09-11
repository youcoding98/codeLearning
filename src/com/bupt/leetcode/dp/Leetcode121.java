package com.bupt.leetcode.dp;

/**
 * Leetcode121:买卖股票的最佳时机
 * @author Administrator
 */
public class Leetcode121 {
    public int maxProfit(int[] prices) {
        int l = prices.length;
        if (l < 2){
            return 0;
        }
        int result = 0;
        int minPrice = prices[0];
        for (int i = 1; i < l; i++) {
            result = Math.max(result,prices[i]-minPrice);
            minPrice = Math.min(minPrice,prices[i]);
        }
        return result;
    }
}
