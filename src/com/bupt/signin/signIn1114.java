package com.bupt.signin;

import java.beans.IntrospectionException;
import java.util.*;

/**
 * Leetcode1122:数组的相对排序
 */
public class signIn1114 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0){
            return new int[]{};
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num:arr1) {
            list.add(num);
        }
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i],i);
        }
        Collections.sort(list,(x,y) -> {
            if (map.containsKey(x) || map.containsKey(y)){
                return map.getOrDefault(x,1001) - map.getOrDefault(y,1001);
            }
            return x - y;
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }
}
