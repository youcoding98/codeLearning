package com.bupt.leetcode.binarysearch;

/**
 * Leetcode081:搜索旋转排序数组II
 * @author gy
 */
public class Leetcode081 {
    public boolean search(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return true;
            }
            //去重
            if (nums[left] == nums[mid]){
                left++;
                continue;
            }
            if (nums[left] <= nums[mid]){
                if (target >= nums[left] && target <= nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if (target >= nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
