package com.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 中序遍历非递归
 * @author Administrator
 */
public class Leetcode094_2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        TreeNode r = root;
        while (r != null || !stack.isEmpty()){
            while (r != null){
                stack.push(r);
                r = r.left;
            }
            r = stack.pop();
            result.add(r.val);
            r = r.right;
        }
        return result;

    }

}
