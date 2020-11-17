package com.bupt.signin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leetcode1030:距离顺序排列矩阵单元格
 * @author Administrator
 */
public class signIn1117 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] array = new int[R*C][2];
        int index = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                array[index][0] = i;
                array[index][1] = j;
                index++;
            }
        }
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0)) - (Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0));
            }
        });

        return array;
    }
}
