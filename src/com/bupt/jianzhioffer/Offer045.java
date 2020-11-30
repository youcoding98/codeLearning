package com.bupt.jianzhioffer;

import java.util.*;

/**
 * Offer045:把数组排成最小的数
 * @author Administrator
 */
public class Offer045 {
    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num:nums) {
            list.add(String.valueOf(num));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        String result = "";
        for (String s:list) {
            result += s;
        }
        return result;
    }
}
