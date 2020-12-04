package com.bupt.signin;


import java.util.*;

/**
 * Leetcode659：分割数组为连续子序列
 * @author Administrator
 */
public class signIn1204 {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int x:nums) {
            if (!map.containsKey(x)){
                map.put(x,new PriorityQueue<>());
            }
            if (map.containsKey(x-1)){
                int preLength = map.get(x - 1).poll();
                if (map.get(x - 1).isEmpty()){
                    map.remove(x-1);
                }
                map.get(x).offer(preLength + 1);
            }else {
                map.get(x).offer(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, PriorityQueue<Integer>>> it = entrySet.iterator();
        while (it.hasNext()){
            Map.Entry<Integer, PriorityQueue<Integer>> mapTemp = it.next();
            if (mapTemp.getValue().peek() < 3){
                return false;
            }
        }
        return true;
    }
}
