package com.bupt.leetcode.dp;

import java.util.List;

/**
 * Leetcode120:三角形最小路径和
 * @author Administrator
 */
public class Leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            for (int j = 1; j < n; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j-1],dp[i-1][j]);
            }
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result,dp[n-1][i]);
        }
        return result;
    }
}
