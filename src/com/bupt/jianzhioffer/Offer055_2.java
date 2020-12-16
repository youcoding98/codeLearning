package com.bupt.jianzhioffer;

/**
 * Offer055_2:平衡二叉树
 * @author Administrator
 */
public class Offer055_2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        if (Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1){
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    public int treeDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(treeDepth(root.left),treeDepth(root.right)) + 1;
    }
}
