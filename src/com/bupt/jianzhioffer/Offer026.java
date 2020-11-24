package com.bupt.jianzhioffer;


/**
 * Offer026:树的子结构
 * @author Administrator
 */
public class Offer026 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null){
            return false;
        }
        return isSubTree(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public boolean isSubTree(TreeNode A,TreeNode B){
        if (B == null){
            return true;
        }
        if (A == null){
            return false;
        }
        return (A.val == B.val) && isSubTree(A.left,B.left) && isSubTree(A.right,B.right);
    }
}
