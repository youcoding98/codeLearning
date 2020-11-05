package com.bupt.leetcode.slidingwindows;

/**
 * Leetcode1208:尽可能使字符串相等
 * @author Administrator
 */
public class Leetcode1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] cost = new int[len];
        for (int i = 0; i < len; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int left = 0,right = 0;
        int maxLen = 0;
        int currentCost = 0;
        while (right < len && left < len){
            currentCost += cost[right];
            while (currentCost > maxCost && left < len){
                currentCost -= cost[left];
                left++;
            }
            maxLen = Math.max(maxLen,right - left + 1);
            right++;

        }
        return maxLen;
    }
}
