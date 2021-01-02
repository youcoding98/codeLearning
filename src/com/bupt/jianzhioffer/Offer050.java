package com.bupt.jianzhioffer;

import java.util.HashMap;

/**
 * Offer050：第一个只出现一次的字符
 * @author Administrator
 */
public class Offer050 {
    public char firstUniqChar(String s) {
        if (s.equals("")){
            return ' ';
        }
        int[] nums = new int[26];
        char[] array = s.toCharArray();
        for (char c:array) {
            nums[c - 'a']++;
        }
        for (char c:array) {
            if (nums[c - 'a'] == 1){
                return c;
            }
        }
        return ' ';
    }
}
