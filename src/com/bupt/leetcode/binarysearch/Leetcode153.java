package com.bupt.leetcode.binarysearch;

/**
 * Leetcode153:寻找旋转排序数组中的最小值
 * @author gy
 */
public class Leetcode153 {
    public int findMin(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int left = 0,right = nums.length - 1;
        while (left <= right){
            if (nums[left] < nums[right]){
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }
            if (nums[left] < nums[mid]){
                left = mid;
            }else{
                right = mid;
            }
        }
        return -1;
    }
}
