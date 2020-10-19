package com.bupt.signin;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode844:比较含退格的字符串
 * @author Administrator
 */
public class signIn1019 {
    public static boolean backspaceCompare(String S, String T) {

        Deque<Character> deque1 = new ArrayDeque<>();
        Deque<Character> deque2 = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            char C = S.charAt(i);
            if (C == '#'){
                if (!deque1.isEmpty()){
                    deque1.pollLast();
                }
            }else{
                deque1.offerLast(C);
            }
        }
        for (int i = 0; i < T.length(); i++) {
            char C = T.charAt(i);
            if (C == '#'){
                if (!deque2.isEmpty()){
                    deque2.pollLast();
                }
            }else{
                deque2.offerLast(C);
            }
        }
        if (deque1.size() != deque2.size()){
            return false;
        }
        while (!deque1.isEmpty() && !deque2.isEmpty()){
            if (deque1.pollFirst() != deque2.pollFirst()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        if (backspaceCompare("ab#c","ad#c")){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
