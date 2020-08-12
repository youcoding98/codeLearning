package com.bupt.leetcode.tree;

/**
 * Leetcode104:二叉树的最大深度
 * @author Administrator
 */
public class Leetcode104 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
