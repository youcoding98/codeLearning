package com.bupt.leetcode.tree;

/**
 * Leetcode124:二叉树最大路径和
 * @author Administrator
 */
public class Leetcode124 {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return max;
    }

    public int pathSum(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftSum = Math.max(0,pathSum(root.left));
        int rightSum = Math.max(0,pathSum(root.right));
        int rootSum = root.val + leftSum + rightSum;
        max = Math.max(max,rootSum);
        return root.val + Math.max(leftSum,rightSum);
    }
}
