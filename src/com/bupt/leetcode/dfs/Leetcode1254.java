package com.bupt.leetcode.dfs;

/**
 * Leetcode1254:统计封闭岛屿的数目
 * @author Administrator
 */
public class Leetcode1254 {
    private static final int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    private int rows;
    private int cols;
    private int[][] grid;
    private boolean[][] marked;
    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        rows = grid.length;
        cols = grid[0].length;
        marked = new boolean[rows][cols];
        if (rows <= 2 || cols <= 2){
            return 0;
        }
        int count = 0;
        this.grid = grid;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && !marked[i][j]){
                    if (dfs(i,j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean dfs(int i, int j){
        if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1){
            if (grid[i][j] == 0){
                return false;
            }
        }
        if (i > 0 && i < rows - 1 && j > 0 && j < cols - 1 && !marked[i][j] && grid[i][j] == 0){
            marked[i][j] = true;
            return dfs(i+1,j) & dfs(i-1,j) & dfs(i,j+1) & dfs(i,j-1);
        }

        return true;
    }
}
