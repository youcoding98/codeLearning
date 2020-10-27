package com.bupt.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode054:螺旋矩阵
 * @author Administrator
 */
public class Leetcode054 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0){
            return result;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        // 初始化
        int left = 0;
        int right = col - 1;
        int up = 0;
        int down = row - 1;
        int nums = row * col;
        while (nums >= 1){
            for (int i = left; i <= right&&nums>=1; i++) {
                result.add(matrix[up][i]);
                nums--;
            }
            up++;
            for (int i = up; i <= down&&nums>=1; i++) {
                result.add(matrix[i][right]);
                nums--;
            }
            right--;
            for (int i = right; i >= left&&nums>=1 ; i--) {
                result.add(matrix[down][i]);
                nums--;
            }
            down--;
            for (int i = down; i >= up&&nums>=1 ; i--) {
                result.add(matrix[i][left]);
                nums--;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(nums);
    }
}
