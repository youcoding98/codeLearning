package com.bupt.jianzhioffer;

import java.util.HashMap;

/**
 * Offer050：第一个只出现一次的字符
 * @author Administrator
 */
public class Offer050 {
    public char firstUniqChar(String s) {
        if (s.length() == 0 || s == null){
            return ' ';
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c= s.charAt(i);
            if (map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else {
                map.put(c,1);
            }
        }
        char result = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1){
                result = s.charAt(i);
                break;
            }
        }
        return result;
    }
}
