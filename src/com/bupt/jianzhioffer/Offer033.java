package com.bupt.jianzhioffer;

/**
 * Offer033:二叉搜索树的后序遍历序列
 * @author gy
 */
public class Offer033 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0 || postorder.length == 1 || postorder == null){
            return true;
        }
        int len = postorder.length;
        int root = postorder[len - 1];
        int mid = 0;
        while (postorder[mid] < root && mid < len){
            mid++;
        }
        for (int i = mid; i < len; i++) {
            if (postorder[i] < root){
                return false;
            }
        }
        return verifyPostorderHelp(postorder,0,mid - 1) && verifyPostorderHelp(postorder,mid,len - 1);
    }

    public boolean verifyPostorderHelp(int[] postorder,int start,int end){
        if (start >= end){
            return true;
        }
        int root = postorder[end];
        int mid = start;
        while (postorder[mid] < root && mid < end){
            mid++;
        }
        for (int i = mid; i < end; i++) {
            if (postorder[i] < root){
                return false;
            }
        }
        return verifyPostorderHelp(postorder,start,mid - 1) && verifyPostorderHelp(postorder, mid, end - 1);

    }

}
