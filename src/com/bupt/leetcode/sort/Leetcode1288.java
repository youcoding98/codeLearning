package com.bupt.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Leetcode1288:删除被覆盖区间
 * @author Administrator
 */
public class Leetcode1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]){
                return o2[1]-o1[1];
            }else{
                return o1[0]-o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int leftNext = intervals[i][0];
            int rightNext = intervals[i][1];
            int right = list.get(list.size() - 1)[1];
            int left = list.get(list.size() - 1)[0];
            if (leftNext <= right && rightNext <= right){
                continue;
            }
            list.add(new int[]{leftNext,rightNext});
        }
        return list.size();
    }
}
