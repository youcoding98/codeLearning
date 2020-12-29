package com.bupt.leetcode.dp;

/**
 * Leetcode322:零钱兑换
 * @author Administrator
 */
public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = amount + 1;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0){
                    min = Math.min(dp[i - coins[j]] + 1,min);
                }
            }
            dp[i] = min;
        }
        if (dp[amount] == amount + 1){
            return -1;
        }
        return dp[amount];
    }
}
