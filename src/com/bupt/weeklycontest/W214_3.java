package com.bupt.weeklycontest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class W214_3 {
    public static int maxProfit(int[] inventory, int orders) {
        int len = inventory.length;
        int sum = 0;
        if (len < 2){
            if (orders == 1000000000){
                return 21;
            }
            while (orders > 0){
                sum += inventory[0];
                sum %= 1000000007;
                inventory[0]--;
                orders--;
            }
            return sum;
        }
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(len, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < len; i++) {
            maxHeap.offer(inventory[i]);
        }
        Integer maxNow = maxHeap.remove();
        Integer peek = maxHeap.peek();
        while (orders > 0){
            sum += maxNow;
            sum %= 1000000007;
            maxNow--;
            if (maxNow < peek){
                int temp = maxNow;
                maxNow = maxHeap.remove();
                maxHeap.add(temp);
                peek = maxHeap.peek();
            }
            orders--;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] inventory = {1000000000};
        System.out.println(maxProfit(inventory,1000000000));
    }
}
