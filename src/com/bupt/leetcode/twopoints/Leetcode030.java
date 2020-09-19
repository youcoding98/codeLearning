package com.bupt.leetcode.twopoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode030:串联所有单词的子串
 * @author Administrator
 */
public class Leetcode030 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0 || words == null){
            return result;
        }
        String[] copyWords = new String[words.length];
        int len = words[0].length() * words.length;
        for (int i = 0; i <= s.length() - len; i++) {
            String subString = s.substring(i,i + len);
            int l = 0;
            for (int j = 0; j < words.length; j++) {
                copyWords[j] = subString.substring(l,l + words[0].length());
                l = l + words[0].length();
            }
            Arrays.sort(words);
            Arrays.sort(copyWords);
            boolean flag = true;
            for (int j = 0; j < words.length; j++) {
                if (!words[j].equals(copyWords[j])){
                    flag = false;
                    break;
                }
            }
            if (flag){
                result.add(i);
            }
        }
        return result;
    }
}
