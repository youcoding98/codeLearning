package com.bupt.leetcode.slidingwindows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode438:找到字符串中所有字母异位词
 * @author Administrator
 */
public class Leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()){
            return result;
        }
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c1 = s.charAt(i);
            map1.put(c1,map1.getOrDefault(c1,0) + 1);
            char c2 = p.charAt(i);
            map2.put(c2,map2.getOrDefault(c2,0) + 1);
        }
        int i = 0;
        for (i = 0; i < s.length() - p.length(); i++) {
            if (map1.equals(map2)){
                result.add(i);
            }
            char temp = s.charAt(i + p.length());
            char c = s.charAt(i);
            map1.put(temp,map1.getOrDefault(temp,0) + 1);
            if (map1.get(c) == 1){
                map1.remove(c);
            }else {
                map1.put(c,map1.get(c) - 1);
            }
        }
        if (map1.equals(map2)){
            result.add(i);
        }
        return result;
    }
}
