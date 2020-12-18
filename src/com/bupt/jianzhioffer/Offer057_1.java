package com.bupt.jianzhioffer;

/**
 * Offer057_1:和为s的两个数字
 * @author Administrator
 */
public class Offer057_1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2){
            return new int[]{};
        }
        int left = 0,right = nums.length - 1;
        while (left < right){
            if (nums[left] + nums[right] < target){
                left++;
            }else if (nums[left] + nums[right] > target){
                right--;
            }else {
                return new int[]{nums[left],nums[right]};
            }
        }
        return new int[]{};
    }

}
