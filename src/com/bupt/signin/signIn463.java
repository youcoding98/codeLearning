package com.bupt.signin;

/**
 * Leetcode463:岛屿的周长
 * @author Administrator
 */
public class signIn463 {

    private int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int islandNums = 0;
        int joinNums = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1){
                    islandNums++;
                    for (int k = 0; k < 4; k++) {
                        int newX = i + directions[k][0];
                        int newY = j + directions[k][1];
                        if (newX < 0 || newX >= row){
                            continue;
                        }
                        if (newY < 0 || newY >= col){
                            continue;
                        }
                        if (grid[newX][newY] == 1){
                            joinNums++;
                        }
                    }
                }
            }
        }
        return islandNums * 4 - joinNums;
    }
}
