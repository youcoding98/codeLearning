package com.bupt.leetcode.tree;

/**
 * Leetcode226：翻转二叉树
 * @author Administrator
 */
public class Leetcode226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
