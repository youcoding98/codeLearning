package com.bupt.leetcode.tree;

/**
 * Leetcode105:从前序与中序遍历序列构造二叉树
 * @author Administrator
 */
public class Leetcode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length){
            return null;
        }
        return help(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }

    private TreeNode help(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
        if (pStart >pEnd || iStart > iEnd){
            return null;
        }
        //重建根节点
        TreeNode root = new TreeNode(preorder[pStart]);
        int mid = 0;
        while (inorder[iStart + mid] != preorder[pStart]){
            mid++;
        }
        root.left = help(preorder, pStart+1, pStart+mid, inorder, iStart, iStart+mid-1);
        root.right = help(preorder, pStart+mid+1, pEnd, inorder, iStart+mid+1, iEnd);
        return root;
    }
}
