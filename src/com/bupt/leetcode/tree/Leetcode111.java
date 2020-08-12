package com.bupt.leetcode.tree;

import java.util.*;

/**
 * Leetcode111:二叉树的最小深度
 * @author Administrator
 */
public class Leetcode111 {

    public int minDepth(TreeNode root) {
        int depth = 0;
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return depth;
        }
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> queueTemp = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode temp = queue.remove();
                if (temp.left == null && temp.right == null){
                    flag = true;
                    break;
                }
                if (temp.left != null){
                    queueTemp.offer(temp.left);
                }
                if (temp.right != null){
                    queueTemp.offer(temp.right);
                }
                list.add(temp.val);
            }
            queue = queueTemp;
            result.add(list);
            if (flag){
                depth = result.size();
                break;
            }
        }
        return depth;
    }
}
