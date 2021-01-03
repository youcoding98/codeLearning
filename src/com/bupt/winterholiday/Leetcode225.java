package com.bupt.winterholiday;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode225:用队列实现栈
 * @author gy
 */
public class Leetcode225 {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public Leetcode225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x);
        while (!queue2.isEmpty()){
            queue1.offer(queue2.remove());
        }
        while (!queue1.isEmpty()){
            queue2.offer(queue1.remove());
        }
    }

    public int pop() {
        return queue2.remove();
    }


    public int top() {
        return queue2.peek();
    }


    public boolean empty() {
        return queue2.isEmpty();
    }
}
