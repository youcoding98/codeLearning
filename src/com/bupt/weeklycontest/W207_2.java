package com.bupt.weeklycontest;

import java.util.HashMap;
import java.util.HashSet;

/**
 * W207_2:拆分字符串使唯一子字符串的数目最大
 * @author Administrator
 */
public class W207_2 {
    public static int maxUniqueSplit(String s) {
        int result = 1;
        HashSet<String> set = new HashSet<>();
        int j = 0;
        for (int i = 0; i < s.length(); ) {
            String s1 = Character.toString(s.charAt(i));
            j = i + 1;
            if (!set.contains(s1)){
                set.add(s1);
            }else {
                while (j < s.length()){
                    j = j + 1;
                    String s2 = s.substring(i,j);
                    if (!set.contains(s2)){
                        set.add(s2);
                        break;
                    }
                    j++;
                }
            }
            i = j;

        }
        if (set.size() > 0){
            result = set.size();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxUniqueSplit("addbsd"));
    }
}
