package com.bupt.jianzhioffer;

/**
 * Offer004:二维数组中的查找
 * @author gy
 */
public class Offer004 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix == null){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col - 1;
        while (i < row && j >= 0 ){
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
