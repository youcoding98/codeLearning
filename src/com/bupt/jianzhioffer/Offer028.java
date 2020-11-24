package com.bupt.jianzhioffer;

/**
 * Offer028:对称的二叉树
 * @author Administrator
 */
public class Offer028 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetricHelp(root.left,root.right);
    }

    public boolean isSymmetricHelp(TreeNode A,TreeNode B){
        if (A == null && B == null){
            return true;
        }
        if (A == null || B == null){
            return false;
        }
        if (A.val != B.val){
            return false;
        }
        return isSymmetricHelp(A.left, B.right) && isSymmetricHelp(A.right,B.left);
    }
}
