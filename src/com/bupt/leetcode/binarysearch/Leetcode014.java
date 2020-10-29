package com.bupt.leetcode.binarysearch;

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
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen,strs[i].length());
        }
        int left = 0,right = minLen;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(isCommonPrefix(strs,mid)){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        if (right < 0){
            return "";
        }
        return strs[0].substring(0,right);
    }

    public boolean isCommonPrefix(String[] strs,int length){
        String str0 = strs[0].substring(0,length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

}
