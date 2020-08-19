package com.bupt.leetcode.hashtable;

import java.util.HashMap;

/**
 * Leetcode001:两数之和
 * @author Administrator
 */
public class Leetcode001 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                result = new int[]{i,map.get(target - nums[i])};
                break;
            }
        }
        return result;
    }
}
