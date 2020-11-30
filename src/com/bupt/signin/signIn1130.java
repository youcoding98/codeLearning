package com.bupt.signin;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Leetcode767:重构字符串
 * @author Administrator
 */
public class signIn1130 {
    /**
     * 基于最大堆的贪心算法
     * @param S
     * @return
     */
    public static String reorganizeString(String S) {
        if (S.length() < 2){
            return S;
        }
        int len = S.length();
        int[] nums = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            nums[c - 'a'] ++;
            if (nums[c - 'a'] > (len + 1)/ 2){
                return "";
            }
        }
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (nums[o2 - 'a'] < nums[o1 - 'a']){
                    return -1;
                }else{
                    return 1;
                }
                //return  nums[o2 - 'a'] - nums[o1 - 'a'];
            }
        });
        for (char c = 'a'; c <= 'z'; c++) {
            if (nums[c - 'a'] > 0){
                queue.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1){
            char c1 = queue.poll();
            char c2 = queue.poll();
            sb.append(c1);
            sb.append(c2);
            int index1 = c1 - 'a';
            int index2 = c2 - 'a';
            nums[index1]--;
            nums[index2]--;
            if (nums[index1] > 0){
                queue.offer(c1);
            }
            if (nums[index2] > 0){
                queue.offer(c2);
            }
        }
        if (!queue.isEmpty()){
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    /**
     * 基于计数的贪心算法
     * @param S
     * @return
     */
    public String reorganizeString2(String S) {
        if (S == null || S.length() == 0){
            return "";
        }
        int len = S.length();
        int[] nums = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            nums[c - 'a'] ++;
            if (nums[c - 'a'] > (len + 1)/ 2){
                return "";
            }
        }
        char[] newS = new char[len];
        int evenIndex = 0,oddIndex = 1;
        for (int i = 0; i < nums.length; i++) {
            char c = (char) ('a' + i);
            while (nums[i] > 0 && nums[i] <= len / 2 && oddIndex < len){
                newS[oddIndex] = c;
                nums[i]--;
                oddIndex = oddIndex + 2;
            }
            while (nums[i] > 0){
                newS[evenIndex] = c;
                nums[i]--;
                evenIndex = evenIndex + 2;
            }
        }
        return new String(newS);
    }

    public static void main(String[] args) {
        reorganizeString("eqmeyggvp");
    }
}
