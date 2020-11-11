package com.bupt.signin;

/**
 * Leetcode922:按奇偶排序数组II
 * @author Administrator
 */
public class signIn1112 {
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0){
            return new int[0];
        }
        int even = 0;
        int odd = 1;
        while (even < A.length && odd < A.length){
            if (A[even] % 2 == 1){
                while (odd < A.length && A[odd] % 2 != 0){
                    odd = odd + 2;
                }
                swap(A,even,odd);
            }
            even = even + 2;
        }
        return A;
    }

    public void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
