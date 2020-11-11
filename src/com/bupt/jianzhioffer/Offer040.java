package com.bupt.jianzhioffer;

import java.awt.image.Kernel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Offer040:最小的K个数
 * @author Administrator
 */
public class Offer040 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0){
            return new int[]{};
        }
        //默认小顶堆.大顶堆需要重写比较方法
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }
}
