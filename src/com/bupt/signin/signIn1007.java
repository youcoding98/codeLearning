package com.bupt.signin;

/**
 * Leetcode075:颜色分类
 * @author Administrator
 */
public class signIn1007 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2){
            return;
        }
        int two = len;
        int zero = 0;
        int i = 0;
        while (i < two){
            if (nums[i] == 0){
                swap(nums,i,zero);
                i++;
                zero++;
            }else if (nums[i] == 1){
                i++;
            }else {
                two--;
                swap(nums,i,two);
            }
        }

    }

    public void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
