package com.bupt.leetcode.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/**
 * Leetcode437:路径总和III
 * @author Administrator
 */
public class Leetcode437 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        return paths(root, sum) + pathSum(root.left, sum) + pathSum(root.right,sum);
    }

    public int paths(TreeNode root,int sum){
        if (root == null){
            return 0;
        }
        int res = 0;
        if (sum == root.val){
            res = res + 1;
        }
        res += paths(root.left,sum-root.val);
        res += paths(root.right, sum-root.val);
        return res;
    }


}
