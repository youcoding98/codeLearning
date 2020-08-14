package com.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode114:二叉树展开为链表
 * @author Administrator
 */
public class Leetcode114 {
    List<TreeNode> result = new ArrayList<>();
    public void flatten(TreeNode root) {
        NLR(root);
        for (int i = 1; i < result.size(); i++) {
            TreeNode pre = result.get(i-1);
            TreeNode cur = result.get(i);
            pre.left = null;
            pre.right = cur;
        }

    }
    public void NLR(TreeNode root){
        if (root != null){
            result.add(root);
            if (root.left != null){
                NLR(root.left);
            }
            if (root.right != null){
                NLR(root.right);
            }
        }
    }
}
