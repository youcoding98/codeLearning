package com.bupt.signin;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode290:单词规律
 * @author Administrator
 */
public class signIn1216 {
    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String,Character> map2 = new HashMap<>();
        String[] s1 = s.split(" ");
        if (pattern.length() != s1.length){
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!map1.containsKey(c) && !map2.containsKey(s1[i])){
                map1.put(c,s1[i]);
                map2.put(s1[i],c);
            }
            if (map1.containsKey(c)){
                if (!map2.containsKey(s1[i])){
                    return false;
                }
                if (!map1.get(c).equals(s1[i])){
                    return false;
                }
            }
            if (map2.containsKey(s1[i])){
                if (!map1.containsKey(c)){
                    return false;
                }
                if (!map2.get(s1[i]).equals(c)){
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog dog dog";
        wordPattern(pattern,s);
    }
}
