package com.bupt.signin;

/**
 * Leetcode845:数组中的最长山脉
 * @author gy
 */
public class signIn1025 {
    public int longestMountain(int[] A) {
        if(A == null || A.length < 3){
            return 0;
        }
        int result = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i + 1] && A[i] > A[i - 1]) {
                int left = i - 1;
                int right = i + 1;
                while (right < A.length - 1){
                    if(A[right + 1] >= A[right]){
                        break;
                    }
                    right = right + 1;
                }
                while (left > 0){
                    if (A[left -1] >= A[left]){
                        break;
                    }
                    left--;
                }
                result = Math.max(result,right-left+1);
            }
        }
        return result;
    }
}
