package com.bupt.leetcode.bitmanipulation;

/**
 * Leetcode260:只出现一次的数字III
 * @author Administrator
 */
public class Leetcode260 {
    public int[] singleNumber(int[] nums) {
        int n = 0;
        for (int num:nums) {
            n ^= num;
        }
        int x = n & (-n);
        int[] result = new int[2];
        for (int num:nums) {
            if ((x & num) == 0){
                result[0] ^= num;
            }else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
