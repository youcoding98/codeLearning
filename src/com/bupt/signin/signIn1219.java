package com.bupt.signin;

/**
 * Leetcode048:旋转图像
 * @author Administrator
 */
public class signIn1219 {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        //上下翻转
        for (int i = 0; i < rows/2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[rows - 1 - i];
            matrix[rows - 1 - i] = temp;
        }
        //对角线翻转
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
