package com.bupt.jianzhioffer;

/**
 * Offer010_2:青蛙跳台阶问题
 * @author Administrator
 */
public class Offer010_2 {
    public int numWays(int n) {
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }

        return dp[n];
    }
}
