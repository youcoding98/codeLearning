package com.bupt.leetcode.dp;

import java.util.Arrays;

/**
 * Leetcode516:最长回文子序列
 * @author Administrator
 */
public class Leetcode516 {
    public int longestPalindromeSubseq(String s) {
        char[] arr = s.toCharArray();
        int l = arr.length;
        int[][] dp = new int[l][l];
        for (int i = 0; i < l; i++) {
            dp[i][i] = 1;
        }
        for (int i = l-1; i >= 0; i--) {
            for (int j = i+1; j < l; j++) {
                if (arr[i] == arr[j]){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][l-1];
    }
}
