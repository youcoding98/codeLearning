package com.bupt.leetcode.binarysearch;

/**
 * Leetcode240:二维矩阵||
 * @author Administrator
 */
public class Leetcode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int i = row - 1,j = 0;
        while (i >= 0 && j < col){
            if (matrix[i][j] == target){
                return true;
            }else if (matrix[i][j] > target){
                i--;
            }else if (matrix[i][j] < target){
                j++;
            }
        }
        return false;
    }
}
