package com.bupt.signin;

/**
 * Leetcode344:反转字符串
 * @author Administrator
 */
public class signIn1008 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0){
            return;
        }
        int len = s.length;
        int left = 0;
        int right = len - 1;
        while (left < right){
            swap(s,left,right);
            left++;
            right--;
        }
    }

    public void swap(char[] nums,int index1,int index2){
        char temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
