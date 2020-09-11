package com.bupt.leetcode.dp;

import java.util.Arrays;

/**
 * Leetcode213:打家劫舍II
 * @author Administrator
 */
public class Leetcode213 {
    public int rob(int[] nums) {
        int result = 0;
        if (nums.length == 0 || nums == null){
            return result;
        }
        int n = nums.length;
        if (n <= 3){
            if (n == 1){
                return nums[0];
            }else if (n == 2){
                return Math.max(nums[0],nums[1]);
            }else {
                return Math.max(Math.max(nums[0],nums[1]),nums[2]);
            }
        }
        int[] nums1 = Arrays.copyOfRange(nums,0,n-1);
        int result1 = robHelp(nums1);
        int[] nums2 = Arrays.copyOfRange(nums,1,n);
        int result2 = robHelp(nums2);
        return Math.max(result1,result2);

    }

    public int robHelp(int[] nums){
        int n = nums.length;
        int result= 0;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
