package com.bupt.jianzhioffer;


/**
 * Offer027:二叉树的镜像
 * @author Administrator
 */
public class Offer027 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode temp = mirrorTree(root.left);
        TreeNode leftNode = mirrorTree(root.right);
        TreeNode rightNode = temp;
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
