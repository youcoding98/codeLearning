package com.bupt.leetcode.twopoints;

/**
 * Leetcode028:实现strStr()
 * @author Administrator
 */
public class Leetcode028 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0){
            return 0;
        }
        int result = -1;
        int len1 = haystack.length();
        int len2 = needle.length();
        int j = 0;
        for (int i = 0; i < len1; i++) {
            if (haystack.charAt(i) == needle.charAt(j) && i + len2 <= len1){
                String newNums = haystack.substring(i,i+len2);
                if (newNums.equals(needle)){
                    result = i;
                    break;
                }
            }
        }
        return result;
    }
}
