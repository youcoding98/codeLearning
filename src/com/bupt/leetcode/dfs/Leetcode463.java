package com.bupt.leetcode.dfs;

/**
 * Leetcode463:岛屿周长
 * @author Administrator
 */
public class Leetcode463 {
    private static final int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

    private int rows;

    private int cols;


    private int[][] grid;

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1){
                    return dfs(i,j);
                }
            }
        }
        return 0;
    }

    private int dfs(int i,int j){
        if (!(i >= 0 && i < rows && j >= 0 && j < cols)){
            return 1;
        }
        if (grid[i][j] == 0){
            return 1;
        }
        if (grid[i][j] != 1){
            return 0;
        }
        grid[i][j] = 2;

        return dfs(i+1,j) + dfs(i-1,j) + dfs(i,j+1) + dfs(i,j-1);
    }
}
