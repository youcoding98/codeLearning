package com.bupt.winterholiday;

import java.util.HashMap;

/**
 * Leetcode001:两数之和
 * @author gy
 */
public class Leetcode001 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2){
            return new int[]{};
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
