package com.bupt.leetcode.binarysearch;

/**
 * Leetcode033：搜索旋转排序数组
 * @author gy
 */
public class Leetcode033 {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            //mid在左段
            if (nums[mid] >= nums[left]){
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
        return -1;
    }
}
