package com.bupt.leetcode.dp;

/**
 * Leetcode337:打家劫舍III
 * @author Administrator
 */
public class Leetcode337 {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0],res[1]);
    }

    private int[] dfs(TreeNode node){
        if (node == null){
            return new int[]{0,0};
        }

        //分类讨论的标准是：当前结点偷或不偷
        //由于需要后序遍历，所以先计算左右子节点，然后计算当前结点的状态
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        //dp[0]:以当前node为根节点的子树能够偷取的最大价值，规定node结点不偷
        //dp[1]:以当前node为根节点的子树能够偷取的最大价值，规定node结点偷
        int[] dp = new int[2];

        dp[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        dp[1] = node.val + left[0] + right[0];
        return dp;
    }
}
