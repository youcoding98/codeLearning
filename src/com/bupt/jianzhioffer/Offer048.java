package com.bupt.jianzhioffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Offer048:最长不含重复字符的子字符串
 * @author Administrator
 */
public class Offer048 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int result = 0;
        int i = -1, j = 0;
        while (j < s.length()){
            char c = s.charAt(j);
            if (map.containsKey(c)){
                i = Math.max(map.get(c),i);
            }
            map.put(c,j);
            result = Math.max(j- i,result);
            j++;
        }
        return result;
    }
}
