package com.bupt.leetcode.twopoints;

/**
 * Leetcode283：移动零
 * @author Administrator
 */
public class Leetcode283 {
    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = 0;
        while (i < len){
            if (nums[i] == 0){
                i++;
            }else{
                nums[j++] = nums[i];
                i++;
            }
        }
        while (j < len){
            nums[j] = 0;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        int i = 0;
        System.out.println("i");
    }
}
