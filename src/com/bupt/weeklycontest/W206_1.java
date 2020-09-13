package com.bupt.weeklycontest;

/**
 * 周赛206_1:二进制矩阵中的特殊位置
 * @author Administrator
 */
public class W206_1 {
    public int numSpecial(int[][] mat) {
        int result = 0;
        int row = mat.length;
        int col = mat[0].length;
        boolean[][] flag = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1){
                    for (int k = 0; k < row; k++) {
                        if (k != i){
                            if (mat[k][j] == 1){
                                flag[i][j] = true;
                                break;
                            }
                        }
                    }
                    for (int k = 0; k < col; k++) {
                        if (k != j){
                            if (mat[i][k] == 1){
                                flag[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (flag[i][j] == false && mat[i][j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }
}
