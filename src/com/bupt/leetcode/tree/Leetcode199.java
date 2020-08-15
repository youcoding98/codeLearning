package com.bupt.leetcode.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode199:二叉树的右视图
 * @author Administrator
 */
public class Leetcode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> treeList = new ArrayList<>();
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
                if (temp != null){
                    list.add(0,temp.val);
                    queueTemp.offer(temp.left);
                    queueTemp.offer(temp.right);
                }
            }
            queue = queueTemp;
            treeList.add(list);
        }
        for (int i = 0; i < treeList.size(); i++) {
            List<Integer> newList = treeList.get(i);
            result.add(newList.get(0));
        }
        return result;
    }

}
