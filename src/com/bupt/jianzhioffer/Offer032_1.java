package com.bupt.jianzhioffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Offer032_1:从上到下打印二叉树
 * @author Administrator
 */
public class Offer032_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            if (node != null){
                list.add(node.val);
            }
            if (node.left != null){
                queue.offerLast(node.left);
            }
            if (node.right != null){
                queue.offerLast(node.right);
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (int num:list) {
            result[i++] = num;
        }
        return result;
    }
}
