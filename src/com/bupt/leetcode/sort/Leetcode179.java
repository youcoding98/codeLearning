package com.bupt.leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Leetcode179:最大数
 * @author Administrator
 */
public class Leetcode179 {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num:nums) {
            list.add(String.valueOf(num));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        String result = "";
        if (list.get(0).equals("0")){
            return "0";
        }
        for (String s:list) {
            result += s;
        }
        return result;
    }

}
