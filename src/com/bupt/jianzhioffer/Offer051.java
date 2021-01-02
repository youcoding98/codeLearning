package com.bupt.jianzhioffer;

import java.util.LinkedList;

/**
 * Offer051:数组中的逆序对
 * @author Administrator
 */
public class Offer051 {
    int result = 0;
    public int reversePairs(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        return sortMerge(nums,0,nums.length - 1);
    }

    public int sortMerge(int[] nums,int left,int right){
        int mid = left + (right - left) / 2;
        if (left < right){
            sortMerge(nums,left,mid);
            sortMerge(nums,mid + 1,right);
            return mergeArray(nums,left,mid,right);
        }else {
            return 0;
        }
    }


    public int mergeArray(int[] nums,int left,int mid,int right){
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        while (i <= mid){
            while (j <= right && nums[i] > nums[j]){
                j++;
            }
            result += j - mid - 1;
            i++;
        }

        int i1 = left;
        int j1 = mid + 1;
        int k = 0;
        while (i1 <= mid && j1 <= right){
            if (nums[i1] < nums[j1]){
                temp[k] = nums[i1++];
            }else {
                temp[k] = nums[j1++];
            }
            k++;
        }

        while (i1 <= mid){
            temp[k++] = nums[i1++];
        }
        while (j1 <= right){
            temp[k++] = nums[j1++];
        }

        for (int l = 0; l < temp.length; l++) {
            nums[left + l] = temp[l];
        }
        return result;

    }

}
