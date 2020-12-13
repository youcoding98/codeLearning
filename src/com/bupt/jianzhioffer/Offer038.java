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
    boolean[] isUsed;
    StringBuilder sb = new StringBuilder();
    public String[] permutation(String s) {
        if (s == null || s.length() == 0){
            return new String[]{};
        }
        int len = s.length();
        isUsed = new boolean[len];
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        dfs(charArray,0);
        String[] strings = new String[result.size()];
        int index = 0;
        for (String s1: result) {
            strings[index++] = s1;
        }
        return strings;
    }
    public void dfs(char[] charArray,int depth){
        //递归结束条件
        if (depth == charArray.length){
            result.add(sb.toString());
            return;
        }
        //按顺序枚举
        for (int i = 0; i < charArray.length; i++) {
            //排除不合适的选择
            char c = charArray[i];
            if (isUsed[i]){
                continue;
            }
            if (i > 0 && isUsed[i - 1] && charArray[i - 1] == c){
                continue;
            }
            //做选择
            isUsed[i] = true;
            sb.append(c);
            //进入下一层选择
            dfs(charArray,depth + 1);
            //回溯
            isUsed[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }



}
