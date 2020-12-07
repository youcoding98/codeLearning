package com.bupt.jianzhioffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Offer003:数组中的重复数字
 * @author gy
 */
public class Offer003 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i){
                if (nums[nums[i]] == nums[i]){
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
