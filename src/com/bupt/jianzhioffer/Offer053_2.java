package com.bupt.jianzhioffer;

/**
 * Offer053_2:0~n-1中缺失的数字
 * @author Administrator
 */
public class Offer053_2 {
    public int missingNumber(int[] nums) {
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
}
