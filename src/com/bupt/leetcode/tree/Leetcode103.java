package com.bupt.leetcode.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode103:锯齿形层次遍历
 * @author Administrator
 */
public class Leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return result;
        }
        queue.offer(root);
        boolean flag = true;
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
                if (!flag){
                    list.add(0,temp.val);
                }else {
                    list.add(temp.val);
                }

            }
            result.add(list);
            queue = queueTemp;
            flag = !flag;
        }
        return result;
    }
}
