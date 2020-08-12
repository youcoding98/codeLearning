package com.bupt.leetcode.tree;

import java.util.Map;

/**
 * Leetcode110:平衡二叉树
 * @author Administrator
 */
public class Leetcode110 {
    public int treeHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(treeHeight(root.left),treeHeight(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return  true;
        }
        int pHeight = treeHeight(root.left);
        int qHeight = treeHeight(root.right);
        if (Math.abs(pHeight - qHeight) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

}
