package com.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Leetcode098_2 {
    List<Integer> result = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        LNR(root);
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i-1) >= result.get(i)){
                return false;
            }
        }
        return true;
    }

    public void LNR(TreeNode root){
        if (root == null){
            return ;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode r = root;
        while (r != null || !stack.isEmpty()){
            while (r != null){
                stack.push(r);
                r = r.left;
            }
            TreeNode temp = stack.pop();
            result.add(temp.val);
            r = temp.right;
        }

    }

}
