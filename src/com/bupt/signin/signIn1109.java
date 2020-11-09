package com.bupt.signin;

import java.util.*;

/**
 * Leetcode973:最接近原点的K个点
 * @author Administrator
 */
public class signIn1109 {
    Random rand = new Random();
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        randomSelect(points,0,len - 1,K);
        return Arrays.copyOfRange(points,0,K);
    }

    public void randomSelect(int[][] points,int left,int right,int K){
        int pivotId = left + rand.nextInt(right - left + 1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points,right,pivotId);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if (dist <= pivot){
                i++;
                swap(points,i,j);
            }
        }
        i++;
        swap(points,i,right);
        if (K < i - left + 1){
            randomSelect(points,left,i-1,K);
        }else if (K > i - left + 1){
            randomSelect(points,i + 1,right,K - (i - left + 1));
        }
    }

    public void swap(int[][] points,int index1,int index2){
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }
}
