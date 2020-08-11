package com.bupt.leetcode.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode102:二叉树的层序遍历
 * @author Administrator
 */
public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
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
            result.add(list);
            queue = queueTemp;
        }
        return result;
    }

}
