package com.bupt.signin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode1002:查找常用字符
 * @author Administrator
 */
public class signIn1014 {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        if (A == null || A.length == 0){
            return result;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for (Character c:A[0].toCharArray()) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        for (int i = 1; i < A.length; i++) {
            String str = A[i];
            HashMap<Character,Integer> map2 = new HashMap<>();
            for (Character c:str.toCharArray()) {
                if (map.containsKey(c)){
                    map2.put(c,Math.min(map.get(c),map2.getOrDefault(c,0) + 1));
                }
            }
            map = map2;
        }
        for (Character c: map.keySet()) {
            int num = map.get(c);
            for (int i = 0; i < num; i++) {
                result.add(c + "");
            }
        }
        return result;
    }
}
