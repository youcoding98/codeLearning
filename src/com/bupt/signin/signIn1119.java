package com.bupt.signin;

/**
 * Leetcode283:移动零
 * @author Administrator
 */
public class signIn1119 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length){
            nums[j] = 0;
            j++;
        }
    }
}
