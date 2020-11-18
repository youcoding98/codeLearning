package com.bupt.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode071:简化路径
 * @author Administrator
 */
public class Leetcode071 {
    public String simplifyPath(String path) {
        String[] s = path.split("/");
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("") || s[i].equals(".")){
                continue;
            }
            if (!stack.isEmpty()){
                if (s[i].equals("..")){
                    stack.pop();
                }else {
                    stack.push(s[i]);
                }

            }else {
                if (!s[i].equals("..")){
                    stack.push(s[i]);
                }
            }
        }
        if (stack.isEmpty()){
            return sb.append("/").toString();
        }
        while (!stack.isEmpty()){
            sb.insert(0,stack.pop());
            sb.insert(0,"/");
        }
        return sb.toString();
    }
}
