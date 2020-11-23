package com.bupt.signin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Leetcode452:用最少数量的箭引爆气球
 * @author Administrator
 */
public class signIn1123 {
    public static int findMinArrowShots(int[][] points) {
        int arrowNum = 0;
        if (points == null || points.length == 0){
            return arrowNum;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]){
                    return -1;
                }else{
                    return 1;
                }

            }
        });
        arrowNum = 1;
        int[] compareArray = {points[0][0],points[0][1]};
        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i];
            if (compareArray[1] < curr[0]){
                arrowNum++;
                compareArray[0] = curr[0];
                compareArray[1] = curr[1];
            }else{
                compareArray[0] = Math.max(compareArray[0],curr[0]);
                compareArray[1] = Math.min(compareArray[1],curr[1]);
            }
        }
        return arrowNum;
    }

    public static void main(String[] args) {
        int[][] points = {
                {1,6},{2,8}};
        System.out.println(findMinArrowShots(points));
    }
}
