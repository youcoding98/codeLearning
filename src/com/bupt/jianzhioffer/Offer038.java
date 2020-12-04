package com.bupt.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Offer038:字符串的排列
 * @author Administrator
 */
public class Offer038 {
    List<String> result = new ArrayList<>();
    boolean[] used;
    StringBuilder sb = new StringBuilder();
    public String[] permutation(String s) {
        int len = s.length();
        if (len == 0) {
            return new String[0];
        }
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        used = new boolean[len];
        dfs(charArray,0);
        String[] s1 = new String[result.size()];
        int i = 0;
        for (String temp:result) {
            s1[i++] = temp;
        }
        return s1;
    }

    public void dfs(char[] charArray,int depth){
        if (depth == charArray.length){
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (used[i]){
                continue;
            }
            if (i > 0 && used[i - 1] && charArray[i-1] == charArray[i]){
                continue;
            }

            used[i] = true;
            sb.append(c);

            dfs(charArray,depth + 1);

            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }



}
