package com.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode145:二叉树的后序遍历
 * @author Administrator
 */
public class Leetcode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if (temp != null){
                result.add(0,temp.val);
                stack.push(temp.left);
                stack.push(temp.right);
            }
        }
        return result;
    }
}
