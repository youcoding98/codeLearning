package com.bupt.jianzhioffer;

import java.util.Stack;

/**
 * Offer031:栈的压入、弹出序列
 * @author gy
 */
public class Offer031 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (j < popped.length && !stack.isEmpty() && popped[j] == stack.peek()){
                stack.pop();
                j++;
            }
        }
        return j == popped.length;
    }
}
