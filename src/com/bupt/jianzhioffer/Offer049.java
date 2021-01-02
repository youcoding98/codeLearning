package com.bupt.jianzhioffer;

import java.util.PriorityQueue;

/**
 * Offer049:丑数
 * @author Administrator
 */
public class Offer049 {
    public static int nthUglyNumber(int n) {
        int[] nums = {2,3,5};
        int count = 0;
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);
        long temp = 1;
        while (count < n){
            temp = heap.poll();
            count++;
            for (int num:nums) {
                long k = num * temp;
                if (!heap.contains(k)){
                    heap.add(k);
                }
            }
        }
        return (int)temp;
    }

    public static void main(String[] args) {
        nthUglyNumber(10);
    }
}
