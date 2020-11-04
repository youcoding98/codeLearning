package com.bupt.signin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Leetcode057:插入区间
 * @author Administrator
 */
public class signIn1104 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int row = intervals.length;
        int[][] input = new int[row + 1][2];
        for (int i = 0; i < row; i++) {
            input[i][0] = intervals[i][0];
            input[i][1] = intervals[i][1];
        }
        input[row][0] = newInterval[0];
        input[row][1] = newInterval[1];
        return merger(input);

    }

    public int[][] merger(int[][] input){
        List<int[]> result = new ArrayList<>();
        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });
        for (int i = 0; i < input.length; i++) {
            int left = input[i][0];
            int right = input[i][1];
            while (i < input.length - 1 && right >= input[i+1][0]){
                right = Math.max(right,input[i+1][1]);
                i++;
            }
            result.add(new int[]{left,right});
        }
        return result.toArray(new int[0][]);
    }
}
