package com.bupt.leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Leetcode451:根据字符出现频率排序
 * @author Administrator
 */
public class Leetcode451 {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0 || s.length() == 1){
            return s;
        }

        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        PriorityQueue<Character> heap = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (map.get(o2).equals(map.get(o1))){
                    return o1.compareTo(o2);
                }
                return map.get(o2) - map.get(o1);
            }
        });
        for (int i = 0; i < s.length(); i++) {
            heap.offer(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()){
            sb.append(heap.poll());
        }
        return sb.toString();
    }
}
