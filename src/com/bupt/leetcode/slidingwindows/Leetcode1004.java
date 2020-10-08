package com.bupt.leetcode.slidingwindows;


/**
 * Leetcode1004:最大连续1的个数
 * @author Administrator
 */
public class Leetcode1004 {
    public int longestOnes(int[] A, int K) {

        if (A == null || A.length == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int zero = 0;
        for (right = 0; right < A.length; right++) {
            if (A[right] == 0){
                zero++;
            }
            if (zero > K){
                if (A[left] == 0){
                    zero--;
                }
                left++;
            }
            count = Math.max(count,right-left+1);
        }
        return count;
    }
}
