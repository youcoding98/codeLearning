package com.bupt.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode049:字母异位词分组
 * @author Administrator
 */
public class Leetcode049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0 || strs == null){
            return result;
        }
        boolean[] flag = new boolean[strs.length];
        Arrays.fill(flag,true);
        for (int i = 0; i < strs.length; i++) {
            if (flag[i]){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                for (int j = i+1; j < strs.length; j++) {
                    if (flag[j]){
                        if (groupAnagramsHelper(strs[i],strs[j])){
                            list.add(strs[j]);
                            flag[j] = false;
                        }
                    }
                }
                flag[i] = false;
                result.add(list);
            }
        }
        return result;
    }

    public boolean groupAnagramsHelper(String s1,String s2){
        if (s1.length() != s2.length()){
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        for (int count:counts) {
            if (count != 0){
                return false;
            }
        }
        return true;
    }
}
