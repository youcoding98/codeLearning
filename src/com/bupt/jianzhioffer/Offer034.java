package com.bupt.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Offer034:二叉树中和为某一值的路径
 * @author gy
 */
public class Offer034 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        sumPath(root,sum,list);
        return result;
    }

    public void sumPath(TreeNode root,int sum,List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null){
            result.add(new ArrayList<>(list));
        }else {
            sumPath(root.left,sum,list);
            sumPath(root.right, sum, list);
        }
        list.remove(list.size() - 1);
    }
}
