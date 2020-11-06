package com.bupt.leetcode.dfs;

/**
 * Leetcode695:岛屿最大面积
 * @author Administrator
 */
public class Leetcode695 {
    private int rows;
    private int cols;
    private int[][] grid;
    private  boolean[][] marked;
    public int maxAreaOfIsland(int[][] grid) {
       if (grid == null || grid.length == 0){
           return 0;
       }
       int max = 0;
       rows = grid.length;
       cols = grid[0].length;
       this.grid = grid;
       marked = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1){
                    max = Math.max(max,dfs(i,j));
                }
            }
        }
        return max;
    }

    private int dfs(int i,int j){
        if (i >= 0 && i < rows && j >= 0 && j < cols && !marked[i][j] && grid[i][j] == 1){
            marked[i][j] = true;
            return dfs(i+1,j) + dfs(i-1,j) + dfs(i,j+1) + dfs(i,j-1) +1;
        }
        return 0;
    }

}
