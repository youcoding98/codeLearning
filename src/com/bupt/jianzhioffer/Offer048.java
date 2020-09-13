package com.bupt.jianzhioffer;

import java.util.HashMap;

/**
 * Offer048:最长不含重复字符的子字符串
 * @author Administrator
 */
public class Offer048 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int len = s.length();
        int start = 0;
        int end = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (end = 0; end < len; end++) {
            char c = s.charAt(end);
            if (map.containsValue(c)){
                start = Math.max(start,map.get(c) + 1);
            }
            map.put(c,end);
            result = Math.max(result,end - start + 1);
        }
        return result;
    }
}
