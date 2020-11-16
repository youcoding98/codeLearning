package com.bupt.leetcode.heap;

import java.util.*;

/**
 * Leetcode692:前K个高频单词
 * @author Administrator
 */
public class Leetcode692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if (words.length == 0 || k == 0){
            return result;
        }
        HashMap<String,Integer> map = new HashMap<>();
        for (String s:words) {
            map.put(s,map.getOrDefault(s,0) + 1);
        }
        /*PriorityQueue<String> priorityQueue = new PriorityQueue<String>(
                (w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                        w2.compareTo(w1) : map.get(w1) - map.get(w2)
        );*/

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1).equals(map.get(o2))){
                    return o2.compareTo(o1);
                }
                return map.get(o1) - map.get(o2);
            }
        });

        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            priorityQueue.offer(key);
            if (priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        while (!priorityQueue.isEmpty()){
            result.add(priorityQueue.poll());
        }
        Collections.reverse(result);
        return result;
    }
}
