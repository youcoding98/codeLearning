package com.bupt.leetcode.slidingwindows;

/**
 * Leetcode485：最大连续1的个数
 * @author Administrator
 */
public class Leetcode485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0 || nums == null){
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < nums.length){
            if (nums[right] == 1){
                max = Math.max(right - left + 1,max);
                right++;
            }else {
                right++;
                left = right;
            }
        }
        return max;
    }
}
