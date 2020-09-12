package com.bupt.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Leetcode205:同构字符串
 * @author Administrator
 */
public class Leetcode205 {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s,t) && isIsomorphicHelper(t,s);
    }

    public boolean isIsomorphicHelper(String s,String t){
        HashMap<Character,Character> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)){
                if (map.get(c1) != c2){
                    return false;
                }
            }else {
                map.put(c1,c2);
            }
        }
        return true;
    }

    /*public String isIsomorphicHelper(String s){
        int n = s.length();
        int[] nums = new int[128];
        int count = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (nums[c] == 0){
                nums[c] = count;
                count++;
            }
            sb.append(nums[c]);
        }
        return sb.toString();
    }*/
}
