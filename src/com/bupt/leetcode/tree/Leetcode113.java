package com.bupt.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Leetcode113:路径总和II
 * @author Administrator
 */
public class Leetcode113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        pathSum(root, sum,result,stack);
        return result;
    }

    public void pathSum(TreeNode root, int sum,List<List<Integer>> result,Deque<Integer> stack){
        if (root == null){
            return;
        }

        sum = sum - root.val;
        stack.addLast(root.val);
        if (sum == 0 && root.left == null && root.right == null){
            result.add(new ArrayList<>(stack));
            stack.removeLast();
            return;
        }
        pathSum(root.left,sum,result,stack);
        pathSum(root.right, sum, result, stack);
        stack.removeLast();
    }
}
