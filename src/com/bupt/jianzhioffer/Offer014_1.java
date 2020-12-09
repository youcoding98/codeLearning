package com.bupt.jianzhioffer;

/**
 * Offer014_1：剪绳子
 * @author Administrator
 */
public class Offer014_1 {
    public int cuttingRope(int n) {
        if (n <= 3){
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n ; i++) {
            if (dp[i - 2] * 2 > dp[i-3] * 3){
                dp[i] = dp[i - 2] * 2;
            }else {
                dp[i] = dp[i - 3] * 3;
            }
        }
        return dp[n];
    }
}
