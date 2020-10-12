package com.bupt.leetcode.slidingwindows;

import java.util.HashMap;

/**
 * Leetcode076:最小覆盖子串
 * @author Administrator
 */
public class Leetcode076 {
    public static String minWindow(String s, String t) {
        int left = 0,right = 0;
        int start = 0,min = Integer.MAX_VALUE;
        HashMap<Character,Integer> windows = new HashMap<>();
        HashMap<Character,Integer> needs = new HashMap<>();
        for (int i = 0; i <t.length(); i++) {
            char c=t.charAt(i);
            needs.put(c,needs.getOrDefault(c,0).intValue()+1);
        }
        int match = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            if (needs.containsKey(c)){
                windows.put(c,windows.getOrDefault(c,0) + 1);
                if (needs.get(c).intValue()==windows.get(c).intValue()){
                    match++;
                }
            }
            right++;

            while (match == needs.size()){
                if (right - left < min){
                    start = left;
                    min = right - left;
                }
                char c1 = s.charAt(left);
                if (needs.containsKey(c1)){
                    if (needs.get(c1).intValue()==windows.get(c1).intValue()){
                        match--;
                    }
                    windows.put(c1,windows.get(c1).intValue()-1);
                }
                left++;
            }
        }
        return min == Integer.MAX_VALUE ?
                "" : s.substring(start, start+min);

    }



}
