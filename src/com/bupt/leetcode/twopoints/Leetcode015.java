package com.bupt.leetcode.twopoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode015:三数之和
 * @author Administrator
 */
public class Leetcode015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3 || nums == null){
            return result;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int L = i + 1;
            int R = len - 1;
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0){
                    result.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L < R && nums[L] == nums[L+1]){
                        L++;
                    }
                    while (L < R && nums[R] == nums[R-1]) {
                        R--;
                    }
                    L++;
                    R--;
                }else if (sum > 0){
                    R--;
                }else {
                    L++;
                }
            }
        }
        return result;
    }
}
