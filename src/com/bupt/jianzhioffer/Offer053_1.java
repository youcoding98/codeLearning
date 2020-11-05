package com.bupt.jianzhioffer;

/**
 * Offer53_1:在排序数组中查找数字、
 * @author Administrator
 */
public class Offer053_1 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int targetIndex = findTarget(target,0,nums.length-1,nums);
        if (targetIndex == -1){
            return 0;
        }
        int count = 1;
        int left = targetIndex - 1;
        int right = targetIndex + 1;
        while (left >= 0){
            if (nums[left] == target){
                count++;
                left--;
            }else{
                break;
            }
        }
        while (right < nums.length){
            if (nums[right] == target){
                count++;
                right++;
            }else {
                break;
            }
        }
        return count;
    }

    public int findTarget(int target,int left,int right,int[] nums){
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] == target){
                return mid;
            }
        }
        return -1;
    }
}
