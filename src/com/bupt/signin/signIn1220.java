package com.bupt.signin;

import java.util.Stack;

/**
 * Leetcode316:去除重复元素
 * @author Administrator
 */
public class signIn1220 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.contains(c)){
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && s.indexOf(stack.peek(),i) != -1){
                stack.pop();
            }
            stack.push(c);
        }
        char[] chars = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            chars[i] = stack.get(i);
        }
        return new String(chars);
    }
}
