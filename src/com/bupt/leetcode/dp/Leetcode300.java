package com.bupt.leetcode.dp;

import java.util.Arrays;

/**
 * Leetcode300:最大上升子序列
 * @author Administrator
 */
public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        int max= 1;
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >= 0 ; j--) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
