package com.bupt.leetcode.tree;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Leetcode100:相同的树
 * @author Administrator
 */
public class Leetcode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null){
            return false;
        }
        if (p != null && q == null){
            return false;
        }

        if (p == null && q == null){
            return true;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);

    }
}
