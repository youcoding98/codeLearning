package com.bupt.jianzhioffer;

/**
 * Offer047:礼物的最大价值
 * @author Administrator
 */
public class Offer047 {
    public int maxValue(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = grid[i][j];
            }
        }
        for (int i = 1; i < rows; i++) {
            dp[i][0] += dp[i-1][0];
        }
        for (int i = 1; i < cols; i++) {
            dp[0][i] += dp[0][i-1];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] += Math.max(dp[i-1][j] ,dp[i][j - 1]);
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
