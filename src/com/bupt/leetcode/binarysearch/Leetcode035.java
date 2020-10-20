package com.bupt.leetcode.binarysearch;

/**
 * Leetcode035:搜索插入位置
 * @author Administrator
 */
public class Leetcode035 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right){
            int middle = (left + right) / 2;
            if (nums[middle] > target){
                right = middle;
            }else if (nums[middle] < target){
                left = middle + 1;
            }else {
                return middle;
            }
        }
        return left;
    }

}
