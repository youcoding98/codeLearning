package com.bupt.signin;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Leetcode103:二叉树的锯齿形层序遍历
 * @author Administrator
 */
public class signIn1222 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        boolean isReverse = false;
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> queueTemp = new ArrayDeque<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.removeFirst();
                if (isReverse){
                    list.add(0,node.val);
                }else {
                    list.add(node.val);
                }
                if (node.left != null){
                    queueTemp.addLast(node.left);
                }
                if (node.right != null){
                    queueTemp.addLast(node.right);
                }
            }
            result.add(list);
            queue = queueTemp;
            isReverse = !isReverse;
        }
        return result;
    }
}
