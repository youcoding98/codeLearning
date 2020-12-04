package com.bupt.leetcode.backtracking;

import java.util.*;

/**
 * Leetcode039:组合总和
 * @author Administrator
 */
public class Leetcode039 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0){
            return result;
        }
        Arrays.sort(candidates);
        dfs(candidates,target,0);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < result.size(); i++) {
            Collections.sort(result.get(i));
            set.add(result.get(i));
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for (List<Integer> list:set) {
            resultList.add(list);
        }
        return resultList;
    }

    public void dfs(int[] candidates, int target,int sum){
        //递归条件终止
        if (sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            //1
            if (sum > target){
                break;
            }
            //2
            path.add(candidates[i]);
            sum += candidates[i];
            //3
            dfs(candidates, target, sum);
            //4
            sum -= path.get(path.size() - 1);
            path.remove(path.size() - 1);
        }
    }
}
