package com.bupt.leetcode.hashtable;

import java.util.HashMap;

/**
 * Leetcode217:存在重复元素
 * @author Administrator
 */
public class Leetcode217 {
    public boolean containsDuplicate(int[] nums) {
        boolean flag = false;
        if (nums.length == 0 || nums == null){
            return false;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                if (map.get(nums[i]) != i){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}
