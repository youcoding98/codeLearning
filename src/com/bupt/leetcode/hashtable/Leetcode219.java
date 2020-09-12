package com.bupt.leetcode.hashtable;

import java.util.HashMap;

/**
 * Leetcode219:存在重复元素
 * @author Administrator
 */
public class Leetcode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return false;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k){
                return true;
            }else {
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
