package com.bupt.leetcode.binarysearch;

/**
 * Leetcode704:二分查找
 * @author Administrator
 */
public class Leetcode704 {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] == target){
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target){
            return -1;
        }
        return right;
    }
}
