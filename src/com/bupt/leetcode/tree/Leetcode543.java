package com.bupt.leetcode.tree;

/**
 * Leetcode543:二叉树的直径
 * @author gy
 */
public class Leetcode543 {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        max = Math.max(max,leftDepth + rightDepth);
        return Math.max(leftDepth,rightDepth) + 1;
    }
}
