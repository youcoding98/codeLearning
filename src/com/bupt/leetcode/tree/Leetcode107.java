package com.bupt.leetcode.tree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode107:二叉树的层序遍历II
 * @author Administrator
 */
public class Leetcode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> queueTemp = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode temp = queue.remove();
                if (temp.left != null){
                    queueTemp.offer(temp.left);
                }
                if (temp.right != null){
                    queueTemp.offer(temp.right);
                }
                list.add(temp.val);
            }
            queue = queueTemp;
            result.add(0,list);
        }
        return result;
    }
}
