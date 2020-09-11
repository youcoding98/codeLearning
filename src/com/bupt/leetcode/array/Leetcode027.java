package com.bupt.leetcode.array;

/**
 * Leetcode027:移除元素
 * @author Administrator
 */
public class Leetcode027 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
