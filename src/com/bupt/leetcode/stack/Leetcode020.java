package com.bupt.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Leetcode020:有效的括号
 * @author Administrator
 */
public class Leetcode020 {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        if(s.length() % 2 == 1){
            return false;
        }
        Stack<Character> stack1 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack1.push(c);
            }else {
                if (!stack1.isEmpty()){
                    Character temp = stack1.pop();
                    if (c == ')' && temp != '('){
                        return false;
                    }
                    if (c == ']' && temp != '['){
                        return false;
                    }
                    if (c == '}' && temp != '{'){
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        if (!stack1.isEmpty()){
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
        isValid("([)]");
    }
}
