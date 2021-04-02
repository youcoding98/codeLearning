package com.bupt.winterholiday;

import java.util.Stack;

/**
 * 反转栈
 */
public class reverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    private static int getStackBottomNum(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int last = getStackBottomNum(stack);
            stack.push(result);
            return last;
        }
    }

    private static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int i = getStackBottomNum(stack);
        reverse(stack);
        stack.push(i);
    }
}
