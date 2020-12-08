package com.bupt.jianzhioffer;

/**
 * Offer012:矩阵中的路径
 * @author Administrator
 */
public class Offer012 {

    private boolean[][] marked;
    private int rows;
    private int cols;
    private char[][] board;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0){
            return false;
        }
        rows = board.length;
        cols = board[0].length;
        marked = new boolean[rows][cols];
        this.board = board;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)){
                    if (dfs(i,j,0,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int i,int j,int index,String word){

        if (index == word.length()){
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || marked[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        marked[i][j] = true;

        boolean flag = dfs(i + 1, j, index + 1, word)
                || dfs(i - 1, j, index + 1, word)
                || dfs(i, j + 1, index + 1, word)
                || dfs(i, j - 1, index + 1, word);
        marked[i][j] = false;
        return flag;

    }

}
