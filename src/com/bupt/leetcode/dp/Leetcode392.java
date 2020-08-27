package com.bupt.leetcode.dp;

/**
 * Leetcode392:判断子序列
 * @author Administrator
 */
public class Leetcode392 {
    public boolean isSubsequence(String s, String t) {
        boolean flag =false;
        if (s == null || s.length() == 0){
            return true;
        }
        if (t == null || t.length() == 0){
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
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

        if (dp[l1][l2] == l1){
            flag = true;
        }
        return flag;
    }
}
