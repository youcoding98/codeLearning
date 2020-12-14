package com.bupt.signin;

import java.util.*;

/**
 * Leetcode049:字母异位词分组
 * @author Administrator
 */
public class signIn1214 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        if (strs == null || strs.length == 0){
            return result;
        }
        for (String s:strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key,list);
        }
        Collection<List<String>> lists = map.values();
        return new ArrayList<List<String>>(lists);
    }


    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs);
    }
}
