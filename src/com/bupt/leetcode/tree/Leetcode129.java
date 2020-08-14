package com.bupt.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Leetcode129:求根到叶子节点数字之和
 * @author Administrator
 */
public class Leetcode129 {

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null){
            return sum;
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        sumNumbers(root,result,path);
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            int pathSum = 0;
            for (int j = 0; j < list.size(); j++) {
                pathSum = pathSum * 10 + list.get(j);
            }
            sum = sum + pathSum;
        }
        return sum;

    }

    public void sumNumbers(TreeNode root, List<List<Integer>> result, Deque<Integer> path){
        if (root == null){
            return;
        }

        path.addLast(root.val);
        if (root.left == null && root.right == null){
            result.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        sumNumbers(root.left, result, path);
        sumNumbers(root.right, result, path);
        path.removeLast();
    }
}
