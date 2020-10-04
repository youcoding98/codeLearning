package com.bupt.signin;

import java.util.HashSet;

/**
 * Leetcode771:宝贝与石头
 * @author Administrator
 */
public class signIn1002 {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            set.add(c);
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (set.contains(c)){
                count++;
            }
        }
        return count;
    }
}
