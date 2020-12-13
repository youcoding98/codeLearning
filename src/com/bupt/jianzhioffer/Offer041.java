package com.bupt.jianzhioffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Offer041:数据流中的中位数
 * @author Administrator
 */
public class Offer041 {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public Offer041() {
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (minHeap.size() - maxHeap.size() > 1){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()){
            return (double) (maxHeap.peek() + minHeap.peek())/2;
        }
        return minHeap.peek();
    }

}
