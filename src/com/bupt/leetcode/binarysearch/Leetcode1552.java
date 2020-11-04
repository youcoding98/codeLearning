package com.bupt.leetcode.binarysearch;

import java.util.Arrays;

/**
 * Leetcode1552:两球之间的磁力
 * @author Administrator
 */
public class Leetcode1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int len = position.length;
        int left = 1;
        int right = position[len - 1] - position[0];
        int result = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (isCanDistance(position,m,mid)){
                left = mid + 1;
                result = mid;
            }else {
                right = mid - 1;
            }
        }
        return result;
    }

    public boolean isCanDistance(int[] position,int m,int mid){
        int j = 0;
        int count = 1;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - position[j] >= mid){
                count++;
                j = i;
            }
        }
        if (count >= m){
            return true;
        }
        return false;
    }
}
