package com.bupt.interview;

import java.util.HashMap;

/**
 * Q1718:最短超串
 * @author Administrator
 */
public class Q1718 {
    public int[] shortestSeq(int[] big, int[] small) {
        int left = 0,right = 0;
        int start = 0,min = Integer.MAX_VALUE;
        HashMap<Integer,Integer> windows = new HashMap<>();
        HashMap<Integer,Integer> needs = new HashMap<>();
        for (Integer c:small) {
            needs.put(c,needs.getOrDefault(c,0) + 1);
        }
        int match = 0;
        while (right < big.length){
            int c1 = big[right];
            if (needs.containsKey(c1)){
                windows.put(c1,windows.getOrDefault(c1,0) + 1);
                if (needs.get(c1) == windows.get(c1)){
                    match++;
                }
            }
            right++;
            while (match == needs.size()){
                if (right - left < min){
                    start = left;
                    min = right - left;
                }
                Integer c2 = big[left];
                if (needs.containsKey(c2)){
                    windows.put(c2,windows.getOrDefault(c2,0) - 1);
                    if (windows.get(c2) < needs.get(c2)){
                        match--;
                    }
                }
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? new int[0] : new int[]{start,start+min-1};
    }
}
