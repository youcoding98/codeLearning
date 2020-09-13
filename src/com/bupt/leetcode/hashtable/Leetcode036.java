package com.bupt.leetcode.hashtable;

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;

/**
 * Leetcode036:有效的数独
 * @author Administrator
 */
public class Leetcode036 {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,Integer>[] rows = new HashMap[9];
        HashMap<Integer,Integer>[] columns = new HashMap[9];
        HashMap<Integer,Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int index = (i / 3) * 3 + (j / 3);
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[index].put(n, boxes[index].getOrDefault(n, 0) + 1);
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
