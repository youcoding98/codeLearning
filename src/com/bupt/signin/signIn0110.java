package com.bupt.signin;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode228:汇总区间
 * @author gy
 */
public class signIn0110 {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        if(nums.length == 1){
            result.add(nums[0] + "");
            return result;
        }
        int left = 0;
        int right = 1;
        while(right < nums.length){
            if(nums[right] != nums[right - 1] + 1){
                String s = "";
                if(right == left + 1){
                    s = nums[left] + "";
                }else{
                    s = nums[left] + "->" + nums[right-1];
                }
                result.add(s);
                left = right;
            }
            right++;
        }
        if(left == nums.length - 1){
            String temp = nums[right-1] + "";
            result.add(temp);
        }else{
            String temp = nums[left] + "->" + nums[right-1];
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        summaryRanges(nums);
    }
}
