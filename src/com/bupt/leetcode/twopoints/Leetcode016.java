package com.bupt.leetcode.twopoints;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;

/**
 * Leetcode016: 最接近三数之和
 * @author Administrator
 */
public class Leetcode016 {
    public static int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {

            int L = i + 1;
            int R = len - 1;
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (target == sum){
                    return target;
                }else if (target > sum){
                    if (min > Math.abs(target-sum)){
                        min = Math.abs(target-sum);
                        result = sum;
                    }
                    L++;

                }else if (target < sum){
                    if (min > Math.abs(target-sum)){
                        min = Math.abs(target-sum);
                        result = sum;
                    }
                    R--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {0,2,1,-3};
        int result = threeSumClosest(nums,-100);
        System.out.println(result);
    }
}
