package com.bupt.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Leetcode003:无重复字符的最长字串
 * @author Administrator
 */
public class Leetcode003 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        //右指针初始化为-1
        int r = -1;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0){
                set.remove(s.charAt(i-1));
            }
            while (r + 1 < s.length() && !set.contains(s.charAt(r+1))){
                set.add(s.charAt(r+1));
                r++;
            }
            ans = Math.max(ans,r+1-i);
        }
        return ans;
    }
}
