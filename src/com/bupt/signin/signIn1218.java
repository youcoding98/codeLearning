package com.bupt.signin;

/**
 * Leetcode389：找不同
 * @author Administrator
 */
public class signIn1218 {
    public char findTheDifference(String s, String t) {
        if (s.length() == 0){
            return t.charAt(0);
        }
        char n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            n ^= c;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            n ^= c;
        }
        return n;
    }
}
