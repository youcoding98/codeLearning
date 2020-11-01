package com.bupt.leetcode.binarysearch;

/**
 * Leetcode074:搜索二维矩阵
 * @author Administrator
 */
public class Leetcode074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0,j = col - 1;
        while (i < row && j >= 0){
            if (matrix[i][j] == target){
                return true;
            }else if (matrix[i][j] > target){
                j--;
            }else if (matrix[i][j] < target){
                i++;
            }
        }
        return false;
    }
}
