package com.bupt.signin;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode129:求根到叶子节点数字之和
 * @author Administrator
 */
public class signIn1029 {
    List<Integer> list = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        int sum = 0;

        if (root == null){
            return sum;
        }
        sumLeaf(root,0);
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public void sumLeaf(TreeNode root,int num){
        if (root.left == null && root.right == null){
            num = num * 10 + root.val;
            list.add(num);
            return;
        }
        num = num * 10 + root.val;
        if (root.left != null){
            sumLeaf(root.left,num);
        }
        if (root.right != null){
            sumLeaf(root.right,num);
        }

    }

}
