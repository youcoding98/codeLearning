package com.bupt.winterholiday;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指Offer59_II：队列的最大值
 * @author ge
 */
public class MaxQueue {
    Deque<Integer> queue = new ArrayDeque<>();
    Deque<Integer> maxQueue = new ArrayDeque<>();
    public MaxQueue() {

    }

    public int max_value() {
        if(queue.isEmpty()){
            return -1;
        }
        return maxQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.addLast(value);
        while (!maxQueue.isEmpty() && value > maxQueue.peekFirst()){
            maxQueue.removeLast();
        }
        maxQueue.addLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        if(queue.peekFirst().equals(maxQueue.peekFirst())){
            maxQueue.removeFirst();
        }
        return queue.removeFirst();
    }
}
