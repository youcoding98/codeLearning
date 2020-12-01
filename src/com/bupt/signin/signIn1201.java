package com.bupt.signin;

/**
 * Leetcode034:在排序数组中查找元素的第一个和最后一个位置
 * @author Administrator
 */
public class signIn1201 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || nums == null){
            return new int[]{-1,-1};
        }
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[2];
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] == target){
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target){
            left = -1;
        }
        result[0] = left;
        left = 0;
        right = nums.length - 1;
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
            right = -1;
        }
        result[1] = right;
        return result;
    }
}
