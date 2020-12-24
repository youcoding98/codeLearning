package com.bupt.signin;

import java.util.Arrays;

/**
 * Leetcode135：分发糖果
 * @author Administrator
 */
public class signIn1224 {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0){
            return 0;
        }
        int len = ratings.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]){
                dp[i] = dp[i - 1] + 1;
            }else {
                dp[i] = 1;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && dp[i] <= dp[i + 1]){
                dp[i] = dp[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int num:dp) {
            sum += num;
        }
        return sum;
    }
}
