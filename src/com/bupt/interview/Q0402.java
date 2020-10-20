package com.bupt.interview;


/**
 * 面试题04.02：最小高度树
 * @author Administrator
 */
public class Q0402 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums,0,nums.length);
    }

    public TreeNode buildBST(int[] nums,int left,int right){
        if (left >= right){
            return null;
        }
        int middle = (left + right) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = buildBST(nums,left,middle);
        node.right = buildBST(nums,middle+1,right);
        return node;
    }
}
