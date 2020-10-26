package com.bupt.signin;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Leetcode1365:有多少小于当前数字的数字
 * @author Administrator
 */
public class signIn1026 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }

        Arrays.sort(result);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < result.length; i++) {
            if(!map.containsKey(result[i])){
                map.put(result[i],i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = map.get(nums[i]);
        }
        return result;
    }
}
