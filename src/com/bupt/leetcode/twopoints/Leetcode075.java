package com.bupt.leetcode.twopoints;

/**
 * Leetcode075:颜色分类
 * @author Administrator
 */
public class Leetcode075 {
    public static void  sortColors(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int left = 0;
        int right = nums.length;
        int i = 0;
        while (i < right){
            if (nums[i] == 0){
                swap(nums,left,i);
                left++;
                i++;
            }else if (nums[i] == 1){
                i++;
            }else {
                right--;
                swap(nums,right,i);
            }
        }

    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
    }
}
