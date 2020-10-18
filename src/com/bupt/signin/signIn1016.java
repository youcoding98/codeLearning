package com.bupt.signin;

/**
 * Leetcode977:有序数组的平方
 * @author Administrator
 */
public class signIn1016 {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0){
            return new int[]{};
        }
        int len = A.length;
        int[] result = new int[len];
        int left = 0;
        int right = len - 1;
        int index = len -1;
        while (left <= right && index >= 0){
            if (A[left] * A[left] > A[right] * A[right]){
                result[index] = A[left] * A[left];
                left++;
            }else{
                result[index] = A[right] * A[right];
                right--;
            }
            index--;
        }
        return result;
    }
}
