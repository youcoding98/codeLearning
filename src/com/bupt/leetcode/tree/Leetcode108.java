package com.bupt.leetcode.tree;

import java.util.Arrays;

/**
 * Leetcode108:将有序数组转换为二叉搜索树
 * @author Administrator
 */
public class Leetcode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return ToBST(nums,0,nums.length-1);
    }

    public TreeNode ToBST(int[] nums,int start,int end){
        if (start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = ToBST(nums,start,mid-1);
        root.right = ToBST(nums,mid+1,end);
        return root;

    }
}
