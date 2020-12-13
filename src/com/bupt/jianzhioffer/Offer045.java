package com.bupt.jianzhioffer;

import java.util.*;

/**
 * Offer045:把数组排成最小的数
 * @author Administrator
 */
public class Offer045 {
    public String minNumber(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int num:nums) {
            result.add(String.valueOf(num));
        }
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s:result) {
            sb.append(s);
        }
        return sb.toString();
    }
}
