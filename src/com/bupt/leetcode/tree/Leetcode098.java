package com.bupt.leetcode.tree;

/**
 * Leetcode098：验证二叉搜索树
 * @author Administrator
 */
public class Leetcode098 {
    public boolean isValidBST(TreeNode root) {
        return isVaildHelp(root,null,null);
    }

    public boolean isVaildHelp(TreeNode root,TreeNode min,TreeNode max){
        if (root == null){
            return true;
        }
        if (min != null && root.val <= min.val){
            return false;
        }
        if (max != null && root.val >= max.val){
            return false;
        }
        return isVaildHelp(root.left, null, root) && isVaildHelp(root.right, root, null);
    }
}
