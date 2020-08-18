package com.bupt.leetcode.tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Leetcode501:二叉搜索树中的众数
 * @author Administrator
 */
public class Leetcode501 {
    int maxTimes = 0;
    int thisTimes = 0;
    List<Integer> res = new LinkedList<Integer>();
    TreeNode pre = null;
    public int[] findMode(TreeNode root) {
        inOrder(root);
        int length = res.size();
        int[] rr = new int[length];
        for(int i = 0; i < length; i++) {
            rr[i] = res.get(i);
        }
        return rr;
    }
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        if(pre != null && pre.val == root.val) {
            thisTimes++;
        } else {
            thisTimes = 1;
        }
        if(thisTimes == maxTimes) {
            res.add(root.val);
        } else if(thisTimes > maxTimes) {
            maxTimes = thisTimes;
            res.clear();
            res.add(root.val);
        }
        pre = root;
        inOrder(root.right);
    }
}



