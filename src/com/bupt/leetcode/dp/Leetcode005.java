package com.bupt.leetcode.dp;

/**
 * Leetcode005:最长回文子串
 * @author Administrator
 */
public class Leetcode005 {
    public String longestPalindrome(String s) {
        int l = s.length();
        int max = 0;
        String result = "";
        boolean[][] dp = new boolean[l][l];
        for (int j = 0; j < l; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j)){
                    if (j - i < 2 || dp[i+1][j-1]){
                        dp[i][j] = true;
                        if (j - i >= max){
                            max = j-i;
                            result = s.substring(i,j);
                        }
                    }
                }
            }
        }
        return result;
    }
}
