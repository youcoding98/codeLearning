package com.bupt.leetcode.dp;

/**
 * Leetcode647：回文子串
 * @author Administrator
 */
public class Leetcode647 {
    public int countSubstrings(String s) {
        int l = s.length();
        boolean[][] dp = new boolean[l][l];
        int result = 0;
        for (int j = 0; j < l; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j)){
                    if (j - i < 2 || dp[i+1][j-1]){
                        dp[i][j] = true;
                        result = result + 1;
                    }
                }
            }
        }
        return result;
    }
}
