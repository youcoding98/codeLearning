package com.bupt.leetcode.tree;

/**
 * Leetcode101:对称二叉树
 * @author Administrator
 */
public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetricHelp(root.left,root.right);

    }

    public static boolean isSymmetricHelp(TreeNode p,TreeNode q){
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSymmetricHelp(p.left,q.right) && isSymmetricHelp(p.right,q.left);
    }
}
