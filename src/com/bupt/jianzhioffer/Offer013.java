package com.bupt.jianzhioffer;

/**
 * Offer013：机器人的运动范围
 * @author Administrator
 */
public class Offer013 {
    private boolean[][] marked;
    private int rows;
    private int cols;
    public int movingCount(int m, int n, int k) {
        if (k == 0){
            return 1;
        }
        rows = m;
        cols = n;
        marked = new boolean[m][n];
        return dfs(0,0,k);

    }

    private int dfs(int i,int j,int k){
        if (i < 0 || i >= rows || j < 0 || j >= cols || marked[i][j] || getNums(i) + getNums(j) > k){
            return 0;
        }
        marked[i][j] = true;
        return dfs(i + 1, j, k) + dfs(i - 1, j, k) + dfs(i,j - 1,k) + dfs(i, j + 1, k) + 1;

    }

    private int getNums(int num){
        int nums = 0;
        while (num >= 10){
            nums += (num % 10);
            num = num / 10;
        }
        nums += num;
        return nums;
    }
}
