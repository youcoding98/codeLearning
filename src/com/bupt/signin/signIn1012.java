package com.bupt.signin;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode530:二叉搜索树的最小绝对差
 * @author Administrator
 */
public class signIn1012 {
    List<Integer> result = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        LNR(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < result.size() ; i++) {
            min = Math.min(min,result.get(i) - result.get(i-1));
        }
        return min;
    }

    public void LNR(TreeNode root){
        if (root != null){
            if (root.left != null){
                LNR(root.left);
            }
            result.add(root.val);
            if (root.right != null){
                LNR(root.right);
            }
        }
    }
}
