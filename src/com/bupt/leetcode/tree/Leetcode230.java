package com.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode230:二叉搜索树中第K小的元素
 * @author Administrator
 */
public class Leetcode230 {
    List<Integer> result = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        LNR(root);
        return result.get(k-1);
    }

    public void LNR(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode r = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (r != null || !stack.isEmpty()){
            while (r != null){
                stack.push(r);
                r= r.left;
            }
            r = stack.pop();
            result.add(r.val);
            r= r.right;
        }
    }
}
