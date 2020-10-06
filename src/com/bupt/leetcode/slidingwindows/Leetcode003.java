package com.bupt.leetcode.slidingwindows;

import java.util.HashSet;

/**
 * Leetcode003:无重复字符的最长子串
 * @author Administrator
 */
public class Leetcode003 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            if (!set.contains(c)){
                set.add(c);
                count = Math.max(right - left + 1,count);
                right++;
            }else{

                set.remove(s.charAt(left));
                left++;
                while (set.contains(c)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(c);
                right++;
            }
        }
        return count;
    }
}
