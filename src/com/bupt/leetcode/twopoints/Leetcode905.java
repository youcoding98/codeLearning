package com.bupt.leetcode.twopoints;

/**
 * Leetcode905：按奇偶排序数组
 * @author Administrator
 */
public class Leetcode905 {
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0){
            return new int[]{};
        }
        int len = A.length;
        int i = 0;
        int j = len - 1;
        while (i < j){

            if (A[i] % 2 == 0){
                i++;
            }
            if (A[j] % 2 == 1){
                j--;
            }
            if (A[i] % 2 == 1 && A[j] % 2 == 0 && i < j){
                swap(A,i,j);
                i++;
                j--;
            }
        }
        return A;
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
