package com.bupt.leetcode.binarysearch;

/**
 * Leetcode154:寻找旋转排序数组中的最小值II
 * @author gy
 */
public class Leetcode154 {
    public int findMin(int[] nums) {

        int left = 0,right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]){
                right = mid;
            }else if (nums[mid] > nums[right]){
                left = mid + 1;
            }else {
                right--;
            }

        }
        return nums[left];
    }
}
