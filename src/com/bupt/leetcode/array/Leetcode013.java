package com.bupt.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode013:罗马数字转整数
 * @author Administrator
 */
public class Leetcode013 {
    public int romanToInt(String s) {

        if (s == null || s.length() == 0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果是最后一个字符
            if (i == s.length() - 1){
                sum += map.get(c);
            }else {
                char cNext = s.charAt(i + 1);
                if (c == 'I'){
                    if (cNext == 'V'){
                        sum += 4;
                        i++;
                    }else if (cNext == 'X'){
                        sum += 9;
                        i++;
                    }else {
                        sum += 1;
                    }
                }else if (c == 'X'){
                    if (cNext == 'L'){
                        sum += 40;
                        i++;
                    }else if (cNext == 'C'){
                        sum += 90;
                        i++;
                    }else {
                        sum += 10;
                    }
                }else if (c == 'C') {
                    if (cNext == 'D') {
                        sum += 400;
                        i++;
                    } else if (cNext == 'M') {
                        sum += 900;
                        i++;
                    } else {
                        sum += 100;
                    }
                }else {
                    sum += map.get(c);
                }
            }
        }
        return sum;
    }
}
