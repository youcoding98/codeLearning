package com.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode222:完全二叉树的节点个数
 * @author Administrator
 */
public class Leetcode222 {
    List<Integer> result = new ArrayList<>();
    public int countNodes(TreeNode root) {
        NLR(root);
        return result.size();
    }

    public void NLR(TreeNode root){
        if (root == null){
            return;
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
    }
}
