package com.bupt.leetcode.twopoints;

import java.util.Arrays;

/**
 * Leetcode209:长度最小的子数组
 * @author Administrator
 */
public class Leetcode209 {
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0 || nums == null){
            return 0;
        }
        int len = nums.length;

        int count = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            if (nums[i] >= s){
                return 1;
            }else {
                int j = i + 1;
                sum = nums[i];
                while (j < len){
                    sum += nums[j];
                    if (sum >= s){
                        count = j - i + 1;
                        break;
                    }else {
                        j++;
                    }
                }
            }
            if (count != 0){
                result = Math.min(result,count);
            }
        }
        if (count == 0){
            result = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(minSubArrayLen(11,nums));
    }
}
