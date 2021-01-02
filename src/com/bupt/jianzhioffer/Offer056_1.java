package com.bupt.jianzhioffer;

/**
 * Offer056-1：数组中数字出现的次数
 * @author Administrator
 */
public class Offer056_1 {
    public int[] singleNumbers(int[] nums) {
        if (nums.length == 2){
            return nums;
        }
        int[] result = new int[2];
        int count = 0;
        for (int num:nums) {
            count ^= num;
        }
        int n = count & -count;
        for (int num:nums) {
            if ((n & num) == 0){
                result[0] ^= num;
            }else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
