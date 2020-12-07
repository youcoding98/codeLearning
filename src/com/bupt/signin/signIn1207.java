package com.bupt.signin;

/**
 * Leetcode861:翻转矩阵后的得分
 * @author Administrator
 */
public class signIn1207 {
    public int matrixScore(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        for (int i = 0; i < row; i++) {
            if (A[i][0] != 1){
                //翻转该行
                for (int j = 0; j < col; j++) {
                    if (A[i][j] == 0){
                        A[i][j] = 1;
                    }else {
                        A[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 1; i < col; i++) {
            int count = 0;
            for (int j = 0; j < row; j++) {
                if (A[j][i] == 1){
                    count++;
                }
            }
            if (count < (row + 1)/ 2){
                for (int j = 0; j < row; j++) {
                    if (A[j][i] == 0){
                        A[j][i] = 1;
                    }else {
                        A[j][i] = 0;
                    }
                }
            }
        }

        int num = 0;
        for (int j = 0; j < col; j++) {
            int temp = (int)Math.pow(2,col - j - 1);
            for (int i = 0; i < row; i++) {
                num += A[i][j] * temp;
            }
        }
        return num;
    }
}
