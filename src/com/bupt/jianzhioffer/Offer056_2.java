package com.bupt.jianzhioffer;

/**
 * Offer056_2:数组中数字出现的次数II
 * @author Administrator
 */
public class Offer056_2 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j] >> i) & 1;
            }
            result ^= (sum % 3) << i;
        }
        return result;
    }
}
