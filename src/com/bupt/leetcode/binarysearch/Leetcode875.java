package com.bupt.leetcode.binarysearch;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Leetcode875:爱吃香蕉的珂珂
 * @author Administrator
 */
public class Leetcode875 {
    public int minEatingSpeed(int[] piles, int H) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max,piles[i]);
        }
        int min = 1;
        while (min < max){
            int mid = min + (max - min) / 2;
            if (isBanana(piles,H,mid)){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        return min;
    }

    public boolean isBanana(int[] piles, int H,int K){
        int time = 0;
        for (int pile:piles) {
            time += (pile - 1) / K + 1;
        }
        return time <= H;
    }
}
