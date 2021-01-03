package com.bupt.winterholiday;

import java.util.HashSet;

/**
 * Leetcode003:无重复字符的最长子串
 * @author gy
 */
public class Leetcode003 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        while (left <= right && right < s.length()){
            char c = s.charAt(right);
            while (left <= right && set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            max = Math.max(max,set.size());
            right++;
        }
        return max;
    }
}
