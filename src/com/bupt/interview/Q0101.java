package com.bupt.interview;

/**
 * 面试题01.01：判定字符是否唯一
 */
public class Q0101 {
    public boolean isUnique(String astr) {
        int[] count = new int[26];
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            count[c - 'a']++;
            if (count[c - 'a'] > 1){
                return false;
            }
        }
        return true;
    }
}
