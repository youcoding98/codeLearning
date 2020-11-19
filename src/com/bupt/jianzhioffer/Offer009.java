package com.bupt.jianzhioffer;

import java.util.Stack;

/**
 * Offer009:用两个栈实现队列
 * @author Administrator
 */
public class Offer009 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public Offer009() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty()){
            return -1;
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}
