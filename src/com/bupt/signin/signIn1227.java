package com.bupt.signin;

import java.util.HashMap;

/**
 * Leetcode205:同构字符串
 * @author Administrator
 */
public class signIn1227 {
    public static boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelp(s,t) && isIsomorphicHelp(t,s);
    }

    public static boolean isIsomorphicHelp(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if (map.containsKey(s1)){
                if (map.get(s1) != t1){
                    return false;
                }
            }else {
                map.put(s1,t1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isIsomorphic("ab","aa");
    }
}
