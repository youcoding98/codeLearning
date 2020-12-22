package com.bupt.interview;

/**
 * 面试题1001：合并排序的数组
 * @author Administrator
 */
public class Q1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0){
            if (A[i] > B[j]){
                A[k--] = A[i];
                i--;
            }else {
                A[k--] = B[j];
                j--;
            }
        }
        while (i >= 0){
            A[k--] = A[i--];
        }
        while (j >= 0){
            A[k--] = B[j--];
        }
    }
}
