package com.bupt.leetcode.dp;

/**
 * Leetcode718:最长重复子数组
 * @author Administrator
 */
public class Leetcode718 {
    public int findLength(int[] A, int[] B) {
        int l1 = A.length;
        int l2 = B.length;
        int[][] dp = new int[l1+1][l2+1];
        int max = 0;
        for (int i = 1; i < l1+1; i++) {
            for (int j = 1; j < l2+1; j++) {
                if (A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = 0;
                }
                max = Math.max(dp[i][j],max);
            }
        }
        return max;
    }
}
