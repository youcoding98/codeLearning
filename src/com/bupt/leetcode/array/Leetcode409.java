package com.bupt.leetcode.array;

/**
 * Leetcode409:最长回文串
 * @author Administrator
 */
public class Leetcode409 {
    public int longestPalindrome(String s) {
        int[] count = new int[60];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'A']++;
        }
        int sum = 0;
        for (int num:count) {
            sum += num - (num & 1);
        }
        if (sum < s.length()){
            return sum + 1;
        }
        return sum;
    }
}
