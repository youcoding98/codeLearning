package com.bupt.leetcode.binarysearch;

/**
 * Leetcode069:平方根
 * @author Administrator
 */
public class Leetcode069 {
    public int mySqrt(int x) {
        if (x < 2){
            return x;
        }
        int left = 0,right = x/2 + 1;
        while (left < right){
            int mid = left + (right - left + 1) / 2;
            if ((long)mid * mid < x){
                left = mid;
            }else if ((long)mid * mid > x){
                right = mid - 1;
            }else if ((long)mid * mid == x){
                left = mid;
            }
        }
        return left;
    }
}
