package com.bupt.leetcode.tree;

import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历
 * @author Administrator
 */


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
public class Leetcode094 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null){
            if (root.left != null){
                inorderTraversal(root.left);
            }
            result.add(root.val);
            if (root.right != null){
                inorderTraversal(root.right);
            }
        }
        return result;
    }

}
