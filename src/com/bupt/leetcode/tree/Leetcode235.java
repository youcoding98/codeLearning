package com.bupt.leetcode.tree;

/**
 * Leetcode235：二叉搜索树的最近公共祖先
 * @author Administrator
 */
public class Leetcode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (p.val > q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        if (p.val <= root.val && q.val >= root.val){
            return root;
        }
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }
}
