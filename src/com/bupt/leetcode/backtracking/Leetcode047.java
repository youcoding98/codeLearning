package com.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode047:全排列II
 * @author Administrator
 */
public class Leetcode047 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return result;
        }
        Arrays.sort(nums);
        used = new boolean[len];
        dfs(nums,0);
        return result;
    }

    public void dfs(int[] nums,int depth){
        //递归条件终止
        if (depth == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //枚举遍历
        for (int i = 0; i < nums.length; i++) {
            //排除非法选择
            if (used[i]){
                continue;
            }
            if (i > 0 && nums[i-1] == nums[i] && used[i-1]){
                continue;
            }
            //做选择
            used[i] = true;
            path.add(nums[i]);
            //进入下一层选择
            dfs(nums, depth + 1);
            //回溯
            used[i] = false;
            path.remove(path.size() - 1);

        }
    }
}
