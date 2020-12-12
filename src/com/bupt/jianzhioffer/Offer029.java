package com.bupt.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Offer029:顺时针打印矩阵
 * @author gy
 */
public class Offer029 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int up = 0;
        int down = rows - 1;
        int left = 0;
        int right = cols - 1;
        while (true){
            for (int k = left; k <= right; k++) {
                list.add(matrix[up][k]);
            }
            if (++up > down){
                break;
            }
            for (int k = up; k <= down; k++) {
                list.add(matrix[k][right]);
            }
            if (--right < left){
                break;
            }
            for (int k = right; k >= left; k--) {
                list.add(matrix[down][k]);
            }
            if (--down < up){
                break;
            }
            for (int k = down; k >= up; k--) {
                list.add(matrix[k][left]);
            }
            if (++left > right){
                break;
            }

        }
        int[] result = new int[list.size()];
        int index = 0;
        for (int num:list) {
            result[index++] = num;
        }
        return result;
    }
}
