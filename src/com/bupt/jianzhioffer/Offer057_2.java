package com.bupt.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Offer057_2:和为s的连续正数序列
 * @author Administrator
 */
public class Offer057_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        int left = 1,right = 2;
        while (left < right){
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum == target){
                int[] nums = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    nums[i - left] = i;
                }
                result.add(nums);
                left++;
            }else if (sum > target){
                left++;
            }else if (sum < target){
                right++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
