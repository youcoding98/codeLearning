package com.bupt.leetcode.tree;

/**
 * Leetcode:从中序与后序遍历序列构造二叉树
 * @author Administrator
 */
public class Leetcode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length){
            return null;
        }
        return help(inorder,0,inorder.length-1,postorder,0,postorder.length-1);

    }
    public TreeNode help(int[] inorder,int iStart,int iEnd,int[] postorder,int pStart,int pEnd){
        if (iStart > iEnd || pStart > pEnd){
            return null;
        }
        TreeNode node = new TreeNode(postorder[pEnd]);
        int index = 0;
        while (inorder[iStart + index] != postorder[pEnd]){
            index++;
        }
        node.left = help(inorder,iStart,iStart+index-1,postorder,pStart,pStart+index -1);
        node.right = help(inorder,iStart + index + 1,iEnd,postorder,pStart+index,pEnd-1);
        return node;
    }
}
