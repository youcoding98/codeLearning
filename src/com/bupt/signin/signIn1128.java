package com.bupt.signin;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode493:翻转对
 * @author Administrator
 */
public class signIn1128 {
    public int reversePairs(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        return reversePairsRecursive(nums,0,nums.length - 1);
    }

    public int reversePairsRecursive(int[] nums,int left,int right){
        if (left == right){
            return 0;
        }else {
            int mid = (left + right) / 2;
            int n1 = reversePairsRecursive(nums,left,mid);
            int n2 = reversePairsRecursive(nums,mid + 1,right);
            int result = n1 + n2;

            //统计下标对的数量
            int i = left;
            int j = mid + 1;
            while (i <= mid){
                while (j <= right &&(long) nums[i] > 2 * (long) nums[j]) {
                    j++;
                }
                result += j - mid - 1;
                i++;
            }

            //合并两个排序数组
            int[] temp = new int[right - left + 1];
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


}
