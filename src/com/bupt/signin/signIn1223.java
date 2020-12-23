package com.bupt.signin;

/**
 * Leetcode387:字符串中的第一个唯一字符
 * @author Administrator
 */
public class signIn1223 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0){
            return -1;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)){
                return i;
            }
        }
        return -1;
    }
}
