package com.bupt.jianzhioffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Offer059_2:队列的最大值
 * @author Administrator
 */
class Offer059_2 {
    Deque<Integer> deque;
    Queue<Integer> queue;
    public Offer059_2() {
        deque = new ArrayDeque<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty()){
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        while (!deque.isEmpty() && deque.peekLast() < value){
            deque.removeLast();
        }
        deque.addLast(value);
        queue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        int ans = queue.poll();
        if (ans == deque.peekFirst()){
            deque.removeFirst();
        }
        return ans;
    }
}
