package com.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode515:在每个树行中找到最大值
 * @author Administrator
 */
public class Leetcode515 {
    List<List<Integer>> treeList = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getTreeList(root);
        for (int i = 0; i < treeList.size(); i++) {
            List<Integer> l1 = treeList.get(i);
            result.add(l1.get(0));
        }
        return result;

    }

    public void getTreeList(TreeNode root){
        if (root == null){
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            Deque<TreeNode> queueTemp = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode temp = queue.remove();
                if (temp != null){
                    if (temp.val > max){
                        list.add(0,temp.val);
                        max = temp.val;
                    }else {
                        list.add(temp.val);
                    }
                    if (temp.left != null){
                        queueTemp.offer(temp.left);
                    }
                    if (temp.right != null){
                        queueTemp.offer(temp.right);
                    }
                }
            }
            queue = queueTemp;
            treeList.add(list);
        }
    }


}
