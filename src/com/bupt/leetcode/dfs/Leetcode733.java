package com.bupt.leetcode.dfs;

/**
 * Leetcode733:图像渲染
 * @author Administrator
 */
public class Leetcode733 {
    //方向数组
    private static final int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    //标记数组
    private boolean[][] marked;

    private int rows;

    private int cols;

    private int[][] image;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0){
            return new int[][]{};
        }
        rows = image.length;
        cols = image[0].length;
        this.image = image;
        marked = new boolean[rows][cols];
        int oldColor = image[sr][sc];
        dfs(sr,sc,oldColor,newColor);
        return image;
    }

    private void dfs(int i,int j,int oldColor,int newColor){
        marked[i][j] = true;
        image[i][j] = newColor;
        for (int k = 0; k < 4; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !marked[newX][newY] && image[newX][newY] == oldColor){
                dfs(newX,newY,oldColor,newColor);
            }
        }
    }
}
