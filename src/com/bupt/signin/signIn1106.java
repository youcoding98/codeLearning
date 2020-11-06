package com.bupt.signin;

import java.util.*;

/**
 * Leetcode1356:根据数字二进制下1的数目排序
 */
public class signIn1106 {
    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int[] bit = new int[10001];
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            bit[arr[i]] = tenToBits(arr[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (bit[o1] != bit[o2]){
                    return bit[o1] - bit[o2];
                }else {
                    return o1 - o2;
                }
            }
        });
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int tenToBits(int nums){
        int count = 0;
        while (nums != 0){
            count += nums % 2;
            nums = nums / 2;
        }
        return count;
    }

}
