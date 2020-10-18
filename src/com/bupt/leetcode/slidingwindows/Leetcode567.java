package com.bupt.leetcode.slidingwindows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode567:字符串的排列
 * @author Administrator
 */
public class Leetcode567 {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            map1.put(c1,map1.getOrDefault(c1,0) + 1);
            char c2 = s2.charAt(i);
            map2.put(c2,map2.getOrDefault(c2,0) + 1);
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (map1.equals(map2)){
                return true;
            }
            char temp = s2.charAt(i + s1.length());
            char c = s2.charAt(i);
            map2.put(temp,map2.getOrDefault(temp,0) + 1);
            if (map2.get(c) == 1){
                map2.remove(c);
            }else {
                map2.put(c,map2.get(c) - 1);
            }
        }
        return map1.equals(map2);
    }


    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        if (checkInclusion(s1,s2)){
            System.out.println("TRUE");
        }else {
            System.out.println("FALSE");
        }

    }
}
