package com.bupt.leetcode.tree;

/**
 * Leetcode124:二叉树最大路径和
 * @author Administrator
 */
public class Leetcode124 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftGain = Math.max(0,maxGain(root.left));
        int rightGain = Math.max(0,maxGain(root.right));

        int rootSum = root.val + leftGain + rightGain;

        maxSum = Math.max(maxSum,rootSum);

        return root.val + Math.max(leftGain,rightGain);
    }
}
