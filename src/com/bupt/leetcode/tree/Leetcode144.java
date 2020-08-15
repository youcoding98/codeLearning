package com.bupt.leetcode.tree;

import java.util.*;

/**
 * Leetcode144:二叉树的前序遍历
 * @author Administrator
 */
public class Leetcode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if (temp != null){
                result.add(temp.val);
                stack.push(temp.right);
                stack.push(temp.left);
            }
        }
        return result;
    }
}
