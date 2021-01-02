package com.bupt.jianzhioffer;

/**
 * Offer068_1:二叉搜索树的最近公共祖先
 * @author Administrator
 */
public class Offer068_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }
}
