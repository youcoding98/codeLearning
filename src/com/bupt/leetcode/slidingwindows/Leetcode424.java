package com.bupt.leetcode.slidingwindows;

/**
 * Leetcode424:替换后的最长重复字符
 * @author Administrator
 */
public class Leetcode424 {


    public static int characterReplacement(String s, int k) {
        int[] map = new int[26];

        if (s == null || s.length() == 0){
            return 0;
        }

        char[] c = s.toCharArray();
        int left = 0;
        int right = 0;
        int hisMax = 0;
        for (right = 0; right < c.length; right++) {
            int index = c[right] - 'A';
            map[index]++;
            hisMax = Math.max(hisMax,map[index]);
            if (right - left + 1 > hisMax + k){
                map[c[left] - 'A']--;
                left++;
            }
        }
        return c.length - left;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA",1));
    }

}
