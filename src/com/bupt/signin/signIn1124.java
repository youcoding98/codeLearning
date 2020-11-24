package com.bupt.signin;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Leetcode222:完全二叉树的节点个数
 * @author Administrator
 */
public class signIn1124 {
    List<TreeNode> list = new ArrayList<>();
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        NLR(root);
        return list.size();
    }

    //前序遍历
    public void NLR(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            list.add(temp);
            if (temp.right != null){
                stack.push(temp.right);
            }
            if (temp.left != null){
                stack.push(temp.left);
            }
        }
    }
}
