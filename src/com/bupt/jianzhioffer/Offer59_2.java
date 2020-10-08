package com.bupt.jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Offer59_2:队列的最大值
 * @author Administrator
 */
class Offer59_2 {
    Queue<Integer> queue;
    Deque<Integer> deque;
    public Offer59_2() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty()){
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        while (!deque.isEmpty() && deque.peekLast() < value){
            deque.pollLast();
        }
        deque.offerLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        int ans = queue.poll();
        if (ans == deque.peekFirst()){
            deque.pollFirst();
        }
        return ans;
    }
}
