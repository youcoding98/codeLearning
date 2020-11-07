package com.bupt.leetcode.dfs;

/**
 *
 * Leetcode827:最大人工岛
 * @author gy
 *
 */
public class Leetcode827{
    private static final int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    private int rows;
    private int cols;
    private int[][] grid;
    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] marked1 = new boolean[rows][cols];
                int temp = grid[i][j];
                grid[i][j] = 1;
                max = Math.max(dfs(i,j,marked1),max);
                grid[i][j] = temp;
            }
        }
        return max;
    }

    private int dfs(int i,int j,boolean[][] marked1){
        marked1[i][j] = true;
        if (grid[i][j] == 0 || i < 0 || i >= rows || j < 0 || j >= cols){
            return 0;
        }
        int count = 1;
        for (int k = 0; k < 4; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !marked1[newX][newY] && grid[i][j] == 1){
                count += dfs(newX,newY,marked1);
            }
        }
        return count;
    }
}
