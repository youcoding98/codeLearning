package com.bupt.signin;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode217:存在重复元素
 * @author gy
 */
public class signIn1213 {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num:nums) {
            if (set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
