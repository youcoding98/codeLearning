package com.bupt.leetcode.array;

/**
 * Leetcode014:最长公共前缀
 * @author Administrator
 */
public class Leetcode014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        String result = compareTwoCommon(strs[0],strs[1]);
        for (int i = 2; i < strs.length; i++) {
            if (result.equals("")){
                return "";
            }
            result = compareTwoCommon(strs[i], result);
        }
        return result;

    }
     public String compareTwoCommon(String s1,String s2){
        String result = "";
        int len = Math.min(s1.length(),s2.length());
         for (int i = 0; i < len; i++) {
             if (s1.charAt(i) != s2.charAt(i)){
                 return result;
             }
             result = result + s1.charAt(i);
         }
         return result;
     }
}
