package com.bupt.jianzhioffer;

/**
 * Offer063:股票的最大利润
 * @author Administrator
 */
public class Offer063 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2){
            return 0;
        }
        int maxProfit = 0;
        int minPrices = prices[0];
        for (int i = 1; i < len; i++) {
            maxProfit = Math.max(maxProfit,prices[i] - minPrices);
            minPrices = Math.min(minPrices,prices[i]);
        }
        return maxProfit;
    }
}
