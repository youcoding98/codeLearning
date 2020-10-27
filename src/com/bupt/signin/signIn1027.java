package com.bupt.signin;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode144:二叉树的前序遍历
 * @author Administrator
 */
public class signIn1027 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()){
            TreeNode temp = deque.removeLast();
            if (temp != null){
                result.add(temp.val);
                deque.offerLast(temp.right);
                deque.offerLast(temp.left);
            }
        }
        return result;
    }
}
