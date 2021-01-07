package com.bupt.leetcode.dfs;

/**
 * Leetcode542:01矩阵
 * @author gy
 */
public class Leetcode542 {
    private static final int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    private int rows;
    private int cols;
    private int[][] matrix;
    private int[][] result;
    private boolean[][] marked;
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return matrix;
        }
        rows = matrix.length;
        cols = matrix[0].length;
        marked = new boolean[rows][cols];
        result = new int[rows][cols];
        this.matrix = matrix;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] marked1 = new boolean[rows][cols];
                result[i][j] = dfs(i,j,marked1);
            }
        }
        return result;
    }

    private int dfs(int i,int j,boolean[][] marked1){
        if (i < 0 || i >= rows || j < 0 || j >= cols || marked1[i][j]){
            return 20000;
        }
        if (matrix[i][j] == 0){
            return 0;
        }
        marked1[i][j] = true;
        return Math.min(Math.min(dfs(i+1,j,marked1) + 1,dfs(i-1,j,marked1)) +1,Math.min(dfs(i,j-1,marked1) + 1,dfs(i,j+1,marked1) + 1));
    }
}
