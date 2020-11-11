package com.bupt.leetcode.heap;

import java.util.*;

/**
 * Leetcode347:前K个高频元素
 * @author Administrator
 */
public class Leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k == 0){
            return new int[0];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        //int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        //默认小顶堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()){
            Integer key = iterator.next();//获取key值
            Integer value = map.get(key);
            if (priorityQueue.size() == k){
                if (priorityQueue.peek()[1] < value){
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{key,value});
                }
            }else {
                priorityQueue.offer(new int[]{key,value});
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll()[0];
        }
        return result;

    }


}
