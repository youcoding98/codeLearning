package com.bupt.leetcode.twopoints;

/**
 * Leetcode026:删除排序数组中的重复元素
 * @author Administrator
 */
public class Leetcode026 {
    public static int removeDuplicates(int[] nums) {
        int result = 0;
        if (nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;
        int j = i + 1;
        while (j < nums.length){
            if (nums[i] == nums[j]){
                j++;
            }else {
                nums[i+1] = nums[j];
                i++;
                j++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int result = removeDuplicates(nums);
        System.out.println(nums);
    }
}
