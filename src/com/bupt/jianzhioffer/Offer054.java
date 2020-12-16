package com.bupt.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Offer054:二叉搜索树的第K大节点
 * @author Administrator
 */
public class Offer054 {
    int ans = 0;
    int count = 0;
    public int kthLargest(TreeNode root, int k) {
        LNR(root,k);
        return ans;
    }
    public void LNR(TreeNode root,int k){
        if (root.right != null){
            LNR(root.right,k);
        }
        if (++count == k){
            ans = root.val;
            return;
        }
        if (root.left != null){
            LNR(root.left,k);
        }
    }

}
