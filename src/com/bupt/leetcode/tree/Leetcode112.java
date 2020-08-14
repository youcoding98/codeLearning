package com.bupt.leetcode.tree;

/**
 * Leetcode112：路径总和
 * @author Administrator
 */
public class Leetcode112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            if (sum - root.val == 0 ){
                return true;
            }else{
                return false;
            }

        }
        sum = sum - root.val;
        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
    }
}
