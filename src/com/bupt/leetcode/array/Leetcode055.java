package com.bupt.leetcode.array;

/**
 * Leetcode055:跳跃游戏
 * @author Administrator
 */
public class Leetcode055 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }
        if (nums.length == 1){
            return true;
        }
        int index = nums[0] + 0;
        int i = 1;
        int max = index;
        while (index < nums.length - 1){
            while (i <= index){
                max = Math.max(nums[i] + i,max);
                i++;
            }
            if (max <= index){
                return false;
            }
            index = max;
        }
        return true;
    }
}
