package com.bupt.jianzhioffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Offer032_2:从上到下打印二叉树II
 * @author Administrator
 */
public class Offer032_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()){
            Deque<TreeNode> queueTemp = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                if (node.left != null){
                    queueTemp.offerLast(node.left);
                }
                if (node.right != null){
                    queueTemp.offerLast(node.right);
                }
            }
            queue = queueTemp;
            result.add(list);
        }
        return result;
    }
}
