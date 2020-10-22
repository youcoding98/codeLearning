package com.bupt.signin;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode763:划分字母区间
 * @author Administrator
 */
public class signIn1022 {
    public List<Integer> partitionLabels(String S) {
         int[] array = new int[26];
         List<Integer> result = new ArrayList<>();
         if(S == null || S.length() == 0){
             return result;
         }
        for (int i = 0; i < S.length(); i++) {
            array[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end,array[S.charAt(i) - 'a']);
            if(end == i){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
