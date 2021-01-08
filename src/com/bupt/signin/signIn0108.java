package com.bupt.signin;

/**
 * Leetcode189:旋转数组
 * @author gy
 */
public class signIn0108 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverseArray(nums,0,len-1);
        reverseArray(nums,0,k-1);
        reverseArray(nums,k,len-1);
    }

    public void reverseArray(int[] nums,int left,int right){
        if (left >= right){
            return;
        }
        while (left < right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    public void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
