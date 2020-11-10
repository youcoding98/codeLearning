package com.bupt.signin;

import java.util.Arrays;

/**
 * Leetcode031:下一个排列
 * @author Administrator
 */
public class signIn1110 {
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        while (i >= 0){
            if (nums[i] < nums[i + 1]){
                break;
            }
            i--;
        }
        if (i >= 0){
            int j = len - 1;
            while (j >= i + 1){
                if (nums[j] > nums[i]){
                    swap(nums,i,j);
                    break;
                }
                j--;
            }
        }
        reverse(nums,i + 1,len - 1);

    }

    public static void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void reverse(int[] nums,int start,int end){
        while (start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2};
        nextPermutation(nums);
    }
}
