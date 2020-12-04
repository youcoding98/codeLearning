package com.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode046:全排列
 * @author Administrator
 */
public class Leetcode046 {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] used;
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0 || nums == null){
            return result;
        }
        used = new boolean[len];

        dfs(nums,0);
        return result;
    }

    public void dfs(int[] nums,int depth){
        //递归结束条件
        if (depth == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //遍历
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, depth + 1);

                //回溯
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }


}
