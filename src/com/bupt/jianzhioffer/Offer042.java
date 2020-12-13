package com.bupt.jianzhioffer;

/**
 * Offer042：连续子数组的最大和
 * @author Administrator
 */
public class Offer042 {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + dp[i-1] > nums[i]){
                dp[i] = nums[i] + dp[i-1];
            }else {
                dp[i] = nums[i];
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }
}
