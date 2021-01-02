package com.bupt.leetcode.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode078:子集
 * @author Administrator
 */
public class Leetcode078 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        dfs(nums,list,0);
        result.add(new ArrayList<>());
        return result;
    }

    public void dfs(int[] nums,List<Integer> list,int len){
        for (int i = len; i < nums.length; i++) {
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            dfs(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
