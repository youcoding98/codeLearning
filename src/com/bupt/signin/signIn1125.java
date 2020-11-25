package com.bupt.signin;

/**
 * Leetcode1370:上升下降字符串
 * @author Administrator
 */
public class signIn1125 {
    public String sortString(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            nums[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()){
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0){
                    char c = (char) ('a' + i);
                    sb.append(c);
                    nums[i]--;
                }
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > 0){
                    char c = (char) ('a' + i);
                    sb.append(c);
                    nums[i]--;
                }
            }
        }
        return sb.toString();
    }
}
