package com.bupt.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Offer059_1:滑动窗口的最大值
 * @author Administrator
 */
public class Offer059_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return nums;
        }
        int left = 0;
        int right = k - 1;
        while (right < nums.length){
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                max = Math.max(max,nums[i]);
            }
            list.add(max);
            left++;
            right++;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
