package com.bupt.jianzhioffer;

/**
 * Offer007；重建二叉树
 * @author Administrator
 */
public class Offer007 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder.length == 0 || inorder == null || preorder.length != inorder.length){
            return null;
        }
        int len = preorder.length;
        return buildTreeHelp(preorder,0,len - 1,inorder,0,len - 1);

    }

    private TreeNode buildTreeHelp(int[] preorder,int pStart,int pEnd,int[] inorder,int iStart,int iEnd){
        if (pStart > pEnd || iStart > iEnd){
            return null;
        }
        TreeNode node = new TreeNode(preorder[pStart]);

        int index = 0;
        while (preorder[pStart] != inorder[iStart + index]){
            index++;
        }

        node.left = buildTreeHelp(preorder, pStart + 1, pStart + index, inorder, iStart, iStart + index - 1);
        node.right = buildTreeHelp(preorder, pStart + index + 1, pEnd, inorder, iStart + index + 1, iEnd);
        return node;
    }


}
