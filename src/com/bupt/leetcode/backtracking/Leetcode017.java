package com.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode017:电话号码的字母组合
 * @author Administrator
 */
public class Leetcode017 {
    HashMap<Character,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return result;
        }
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        StringBuilder sb = new StringBuilder();
        dfs(digits,sb,result,0);

        return result;
    }
    
    public void dfs(String digits,StringBuilder sb,List<String> result,int start){
        //1.递归结束条件
        if (start == digits.length()){
            result.add(sb.toString());
            return;
        }
        //按顺序枚举
        String temp = map.get(digits.charAt(start));
        for (int i = 0; i < temp.length(); i++) {
            //1 排除不合适选择

            //2.做选择
            sb.append(temp.charAt(i));

            //3.进入下一层选择
            dfs(digits, sb, result, start + 1);

            //4.取消选择(回溯)
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
