package com.bupt.signin;

/**
 *Leetcode941:有效的山脉数组
 * @author Administrator
 *
 */
public class signIn1103{
    public static boolean validMountainArray(int[] A) {
        if (A.length < 3){
            return false;
        }
        int left = 0,right = A.length - 1;
        while (left < right){
            if (A[right] > A[right - 1] && A[left] > A[left + 1] && left < right){
                return false;
            }
            if (A[left] < A[left + 1]){
                left++;
            }else if (A[left] == A[left + 1]){
                return false;
            }
            if (A[right] < A[right - 1]){
                right--;
            }else if (A[right] == A[right - 1]){
                return false;
            }

        }
        if (left == A.length - 1){
            return false;
        }
        if (right == 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = {0,3,2,2,1,1};
        if (validMountainArray(A)){
            System.out.println("YEs");
        }else{
            System.out.println("NO");
        }
    }
}

