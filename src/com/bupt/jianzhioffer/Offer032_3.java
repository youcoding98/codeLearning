package com.bupt.jianzhioffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Offer032_3:从上到下打印二叉树III
 * @author Administrator
 */
public class Offer032_3 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if  (root == null){
            return result;
        }
        boolean flag = true;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()){
            Deque<TreeNode> queueTemp = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.removeFirst();
                if (flag){
                    list.add(node.val);
                }else {
                    list.add(0,node.val);
                }
                if (node.left != null){
                    queueTemp.offerLast(node.left);
                }
                if (node.right != null){
                    queueTemp.offerLast(node.right);
                }
            }
            flag = !flag;
            queue = queueTemp;
            result.add(list);
        }
        return result;
    }
}
