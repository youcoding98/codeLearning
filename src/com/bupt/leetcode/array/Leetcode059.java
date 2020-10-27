package com.bupt.leetcode.array;

/**
 * Leetcode059:螺旋矩阵II
 * @author Administrator
 */
public class Leetcode059 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int nums = n * n;
        int count = 1;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = n - 1;
        while (nums >= 1){
            for (int i = left; i <= right&&nums >= 1; i++) {
                result[up][i] = count;
                count++;
                nums--;
            }
            up++;
            for (int i = up; i <= down&&nums >= 1; i++) {
                result[i][right] = count;
                count++;
                nums--;
            }
            right--;
            for (int i = right; i >= left&&nums >= 1; i--) {
                result[down][i] = count;
                count++;
                nums--;
            }
            down--;
            for (int i = down; i >= up&&nums>=1 ; i--) {
                result[i][left] = count;
                count++;
                nums--;
            }
            left++;
        }
        return result;
    }
}
