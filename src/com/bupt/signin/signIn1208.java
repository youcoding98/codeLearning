package com.bupt.signin;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode842:将数组拆分成斐波那契序列
 * @author Administrator
 */
public class signIn1208 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new ArrayList<>();
        dfs(S,0,result);
        return result;
    }

    public boolean dfs(String S,int index,List<Integer> list){
        if (index == S.length()){
            return list.size() > 2;
        }
        for (int i = index + 1; i <= S.length() ; i++) {
            String temp = S.substring(index,i);
            if (S.charAt(index) == '0' && i > index + 1 || temp.length() > 10 || Long.valueOf(temp) > Integer.MAX_VALUE){
                break;
            }
            int str = Integer.valueOf(temp);
            int one = list.size() >= 2 ? list.get(list.size() - 1) : -1;
            int two = list.size() >= 2 ? list.get(list.size() - 2) : -1;
            list.add(str);
            if ((one == -1 || two == -1 || one + two == str) && dfs(S,i,list)){
                return true;
            }
            list.remove(list.size() - 1);
        }
        return false;
    }
}
