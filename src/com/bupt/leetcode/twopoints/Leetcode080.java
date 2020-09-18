package com.bupt.leetcode.twopoints;

/**
 * Leetcode080:删除排序数组中的重复项||
 * @author Administrator
 */
public class Leetcode080 {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int count = 1;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]){
                nums[++i] = nums[j];
                count = 1;
            }else if (count >= 2){
                continue;
            }else {
                nums[++i] = nums[j];
                count++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        removeDuplicates(nums);
        System.out.println(nums.toString());
    }
}
