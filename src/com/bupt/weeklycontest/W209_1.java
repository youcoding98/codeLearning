package com.bupt.weeklycontest;

import java.util.Arrays;

/**
 * W209_1:特征数组的特征值
 * @author Administrator
 */
public class W209_1 {
    public static int specialArray(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        if (nums[0] >= len){
            return len;
        }
        int n = len-1;
        while (n > 0){
            if (nums[len-n] >= n && nums[len-n-1] < n){
                return n;
            }
            n--;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0};
        System.out.println(specialArray(nums));
    }
}
