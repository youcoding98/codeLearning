package com.bupt.weeklycontest;

import java.util.HashSet;
import java.util.Set;

public class W220_2 {
    public static int maximumUniqueSubarray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int left = 0,right = 0;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while (right < nums.length && left <= right){
            while (right < nums.length && !set.contains(nums[right])){
                set.add(nums[right]);
                sum += nums[right];
                right++;
            }
            max = Math.max(sum,max);
            sum -= nums[left];
            set.remove(nums[left]);
            left++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,4,5,6};
        maximumUniqueSubarray(nums);
    }
}
