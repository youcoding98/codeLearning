package com.bupt.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode095:不同的二叉搜索树II
 * @author Administrator
 */
public class Leetcode095 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new LinkedList<TreeNode>();
        }
        return generateTree(1,n);
    }

    public List<TreeNode> generateTree(int start,int end){
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end){
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTree(start,i-1);
            List<TreeNode> rightTrees = generateTree(i+1,end);
            //从左子树集合选出一棵左子树，从右子树集合选出一棵右子树
            for (TreeNode left:leftTrees) {
                for (TreeNode right:rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
