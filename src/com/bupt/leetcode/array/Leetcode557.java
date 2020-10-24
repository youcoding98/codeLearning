package com.bupt.leetcode.array;

import java.util.Arrays;

/**
 * Leetcode557:反转字符串中的单词III
 * @author gy
 */
public class Leetcode557 {
    public static String reverseWords(String s) {
        if(s == null || s.length() == 0 || s.length() == 1){
            return s;
        }
        char[] charArray = s.toCharArray();
        StringBuffer sb1 = new StringBuffer();
        for (int i = charArray.length - 1; i >= 0; i--) {
            sb1.append(charArray[i]);
        }
        String reverseS = sb1.toString();
        String[] splitS = reverseS.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = splitS.length - 1; i > 0; i--) {
            sb.append(splitS[i]);
            sb.append(" ");
        }
        sb.append(splitS[0]);
        return sb.toString();
    }

    public static void main(String[] args) {
        reverseWords("Let's take LeetCode contest");
    }
}
