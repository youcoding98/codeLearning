package com.bupt.leetcode.sort;

import com.sun.org.apache.bcel.internal.generic.L2I;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode228：汇总区间
 * @author Administrator
 */
public class Leetcode228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return result;
        }
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j + 1 < nums.length && nums[j+1] == nums[j] + 1){
                continue;
            }
            if (i == j){
                result.add(nums[i] + "");
            }else{
                result.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return result;
    }
}
