package com.bupt.leetcode.array;

import java.util.Arrays;

/**
 * Leetcode238:除自身以外数组的乘积
 * @author gy
 */
public class Leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        int[] leftMul = new int[nums.length];
        Arrays.fill(leftMul,1);
        int[] rightMul = new int[nums.length];
        Arrays.fill(rightMul,1);
        int[] result = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            leftMul[i] = leftMul[i-1] * nums[i-1];
        }
        for (int i = nums.length - 2; i >= 0 ; i--) {
            rightMul[i] = rightMul[i+1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = rightMul[i] * leftMul[i];
        }
        return result;
    }
}
