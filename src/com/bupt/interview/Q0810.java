package com.bupt.interview;

/**
 * 面试题08.10：颜色填充
 * @author gy
 */
public class Q0810 {
    private static final int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    private int cols;
    private int rows;
    private int[][] image;
    private int oldColor;
    private int newColor;
    private boolean[][] marked;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0){
            return new int[][]{};
        }
        rows = image.length;
        cols = image[0].length;
        this.newColor = newColor;
        oldColor = image[sr][sc];
        marked = new boolean[rows][cols];
        this.image = image;
        dfs(sr,sc);
        return image;
    }

    private void dfs(int i,int j){
        image[i][j] = newColor;
        marked[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && image[newX][newY] == oldColor && !marked[newX][newY]){
                dfs(newX,newY);
            }
        }
    }
}
