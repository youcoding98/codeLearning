package com.bupt.signin;

import java.util.*;

/**
 * Leetcode1207:独一无二的出现次数
 * @author Administrator
 */
public class signIn1028 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> map2 = iterator.next();
            if (set.contains(map2.getValue())){
                return false;
            }else{
                set.add(map2.getValue());
            }
        }
        return true;
    }
}
