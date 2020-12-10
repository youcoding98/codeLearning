package com.bupt.jianzhioffer;

import java.util.Map;

/**
 * Offer017:打印从1到最大的n位数
 * @author Administrator
 */
public class Offer017 {
    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10,n);
        int[] nums = new int[max - 1];
        int j = 0;
        for (int i = 1; i < max - 1; i++) {
            nums[j++] = i;
        }
        nums[j] = max - 1;
        return nums;
    }
}
