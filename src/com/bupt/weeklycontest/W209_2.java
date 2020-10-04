package com.bupt.weeklycontest;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * W209_2:奇偶树
 * @author Administrator
 */
public class W209_2 {
    public List<List<Integer>> help(TreeNode root) {
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
    public boolean isEvenOddTree(TreeNode root) {

        List<List<Integer>> result = help(root);
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            if (i % 2 == 0){//偶数
                if (list.get(0) % 2 == 0){
                    return false;
                }
                for (int j = 1; j < list.size(); j++) {

                    if (list.get(j) % 2 == 0){
                        return false;
                    }
                    if (list.get(j-1) >= list.get(j)){
                        return false;
                    }
                }
            }else {
                if (list.get(0) % 2 == 1){
                    return false;
                }
                for (int j = 1; j < list.size(); j++) {

                    if (list.get(j) % 2 == 1){
                        return false;
                    }
                    if (list.get(j-1) >= list.get(j)){
                        return false;
                    }
                }
            }

        }
        return true;
    }


}
