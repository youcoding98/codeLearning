package com.bupt.leetcode.twopoints;

/**
 * Leetcode930：和相同的二元子数组
 * @author Administrator
 */
public class Leetcode930 {
    public static int numSubarraysWithSum(int[] A, int S) {
        int result = 0;
        if (A.length == 0 || A == null){
            return result;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < A.length){
            sum += A[right];
            if (sum < S){
                right++;
            }else if (sum == S){
                int leftTemp = left;
                int sumTemp = sum;
                while (leftTemp <= right && sumTemp == S){
                    result++;
                    sumTemp = sumTemp - A[leftTemp];
                    leftTemp++;
                }
                right++;
            }else {
                sum = sum - A[left] - A[right];
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        System.out.println(numSubarraysWithSum(nums,2));
    }
}
