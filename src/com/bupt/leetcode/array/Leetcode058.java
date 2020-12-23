package com.bupt.leetcode.array;

/**
 * Leetcode058:最后一个单词的长度
 * @author Administrator
 */
public class Leetcode058 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' '){
                while (i >= 0 && s.charAt(i) != ' '){
                    i--;
                    sum++;
                }
                return sum;
            }

        }
        return 0;
    }
}
