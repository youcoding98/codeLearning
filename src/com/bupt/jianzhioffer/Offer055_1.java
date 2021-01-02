package com.bupt.jianzhioffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Offer055_1:二叉树的深度
 * @author Administrator
 */
public class Offer055_1 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            Deque<TreeNode> queueTemp = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                if (node.left != null){
                    queueTemp.addLast(node.left);
                }
                if (node.right != null){
                    queueTemp.addLast(node.right);
                }
            }
            result.add(list);
            queue = queueTemp;
        }
        return result.size();
    }
}
