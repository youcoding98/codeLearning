package com.bupt.leetcode.tree;

import java.util.*;

/**
 * Leetcode257:二叉树的所有路径
 * @author Administrator
 */
public class Leetcode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        List<List<Integer>> pathList = new ArrayList<>();
        allPath(root,pathList,stack);
        for (int i = 0; i < pathList.size(); i++) {
            List<Integer> list = pathList.get(i);
            String path = "";
            for (int j = 0; j < list.size()-1; j++) {
                path = path + list.get(j) + "->";
            }
            path = path + list.get(list.size()-1);
            result.add(path);
        }
        return result;
    }

    public void allPath(TreeNode root,List<List<Integer>> pathList,Deque<Integer> stack){
        if (root == null){
            return;
        }
        stack.addLast(root.val);
        if (root.left == null && root.right == null){
            pathList.add(new ArrayList<>(stack));
            stack.removeLast();
            return;
        }
        allPath(root.left, pathList, stack);
        allPath(root.right, pathList, stack);
        stack.removeLast();
    }
}
