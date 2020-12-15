package com.bupt.jianzhioffer;

/**
 * Offer53_1:在排序数组中查找数字
 * @author Administrator
 */
public class Offer053_1 {
    public int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null){
            return 0;
        }
        int index = findTarget(nums, target);
        if (index == -1){
            return 0;
        }
        int count = 1;
        int left = index - 1;
        int right = index + 1;
        while (left >= 0){
            if (nums[left] == target){
                left--;
                count++;
            }else {
                break;
            }
        }
        while (right < nums.length){
            if (nums[right] == target){
                right++;
                count++;
            }else {
                break;
            }
        }
        return count;
    }

    public int findTarget(int[] nums,int target){
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] == target){
                return mid;
            }
        }
        return -1;
    }
}
