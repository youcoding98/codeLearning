package com.bupt.signin;

/**
 * Leetcode547:省份数量
 * @author gy
 */
public class signIn0107 {
    private int rows;
    private int cols;
    private boolean[] marked;
    private int[][] isConnected;

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null){
            return 0;
        }
        int count = 0;
        rows = isConnected.length;
        cols = isConnected[0].length;
        marked = new boolean[rows];
        this.isConnected = isConnected;
        for (int i = 0; i < rows; i++) {
            if (!marked[i]){
                dfs(i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int i){
        marked[i] = true;
        for (int j = 0; j < cols; j++) {
            if (isConnected[i][j] == 1 && !marked[j]){
                marked[j] = true;
                dfs(j);
            }
        }
    }
}
