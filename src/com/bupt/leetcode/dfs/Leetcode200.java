package com.bupt.leetcode.dfs;

/**
 * Leetcode200:岛屿数量
 * @author Administrator
 */
public class Leetcode200 {
    private static final int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

    private boolean[][] marked;

    private int rows;

    private int cols;

    private char[][] grid;
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0){
            return count;
        }
        rows = grid.length;
        cols = grid[0].length;
        marked = new boolean[rows][cols];
        this.grid = grid;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !marked[i][j]){
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i,int j){
        marked[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (newX >= 0 && newX < rows && newY < cols && newY >= 0 && !marked[newX][newY] && grid[newX][newY] == '1'){
                dfs(newX,newY);
            }
        }
    }
}
