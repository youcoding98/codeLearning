package com.bupt.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode056:合并区间
 * @author Administrator
 */
public class Leetcode056 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals == null){
            return new int[][]{};
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int leftNext = intervals[i][0];
            int rightNext = intervals[i][1];
            int right = list.get(list.size() - 1)[1];
            if (leftNext > right){
                list.add(new int[]{leftNext,rightNext});
            }else {
                right = Math.max(right,rightNext);
                list.get(list.size() - 1)[1] = right;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
