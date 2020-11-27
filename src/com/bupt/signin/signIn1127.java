package com.bupt.signin;

import java.util.HashMap;

/**
 * Leetcode454:四数相加II
 * @author Administrator
 */
public class signIn1127 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int a:A) {
            for (int b:B) {
                map.put(a + b,map.getOrDefault(a+b,0) + 1);
            }
        }

        int ans = 0;

        for (int c:C) {
            for (int d:D) {
                if (map.containsKey(-(c + d))){
                    ans += map.get(-(c + d));
                }
            }
        }
        return ans;
    }
}
