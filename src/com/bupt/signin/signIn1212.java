package com.bupt.signin;

/**
 * Leetcode376:摆动序列
 * @author gy
 */
public class signIn1212 {
    public int[] isCompare;
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2){
            return len;
        }
        int[] dp = new int[len];
        isCompare = new int[len];
        dp[0] = 1;
        if (nums[1] != nums[0]){
            dp[1] = 2;
        }else {
            dp[1] = 1;
        }
        for (int i = 1; i < len; i++) {
            getCompare(nums,i);
        }
        for (int i = 2; i < len; i++) {
            if (isCompare[i] == 0){
                dp[i] = dp[i - 1];
            }else if (isCompare[i] != 0 && isCompare[i] + isCompare[i-1] == 0){
                dp[i] = dp[i - 1] + 1;
            }else if (isCompare[i] != 0 && isCompare[i] + isCompare[i-1] != 0){
                for (int j = i-1; j >= 0; j--) {
                    if (j == 0){
                        dp[i] = 2;
                        break;
                    }
                    if (isCompare[i] + isCompare[j] == 0){
                        dp[i] = dp[j] + 1;
                        break;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public void getCompare(int[] nums,int i){
        if (nums[i] - nums[i-1] > 0){
            isCompare[i] = 1;
        }else if (nums[i] - nums[i-1] < 0){
            isCompare[i] = -1;
        }else {
            isCompare[i] = 0;
        }
    }
}
