package com.bupt.leetcode.dp;

/**
 * Leetcode1143:最长公共子序列
 * @author Administrator
 */
public class Leetcode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        int l1 = arr1.length;
        int l2 = arr2.length;
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 1; i < l1+1; i++) {
            for (int j = 1; j < l2+1; j++) {
                if (arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];
    }
}
