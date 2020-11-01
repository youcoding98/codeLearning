package com.bupt.leetcode.tree;

/**
 * Leetcode687:最长同值路径
 * @author gy
 */
public class Leetcode687 {
    private int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        valuePath(root);
        return max;
    }

    public int valuePath(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDepth = valuePath(root.left);
        int rightDepth = valuePath(root.right);
        if (root.left != null && root.left.val != root.val){
            leftDepth = 0;
        }
        if (root.right != null && root.right.val != root.val){
            rightDepth = 0;
        }
        max = Math.max(max,leftDepth + rightDepth);
        return Math.max(leftDepth,rightDepth) + 1;
    }
}
