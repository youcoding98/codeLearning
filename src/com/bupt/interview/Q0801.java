package com.bupt.interview;

/**
 * 面试题0801：三步问题
 * @author Administrator
 */
public class Q0801 {
    public int waysToStep(int n) {
        if (n <= 2){
            return n;
        }
        if (n == 3){
            return 4;
        }
        int[] dp = new int[n+1];
        for (int i = 4; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}
