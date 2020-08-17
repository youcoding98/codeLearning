package com.bupt.leetcode.tree;

/**
 * Leetcode404:左叶子之和
 * @author Administrator
 */
public class Leetcode404 {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        sumLeft(root);
        return sum;
    }

    public void sumLeft(TreeNode root){
        if (root == null){
            return;
        }

        if (root.left != null && root.left.left == null && root.left.right == null){
            sum = sum + root.val;
        }
        if (root.left != null){
            sumLeft(root.left);
        }
        if (root.right != null){
            sumLeft(root.right);
        }
    }
}
