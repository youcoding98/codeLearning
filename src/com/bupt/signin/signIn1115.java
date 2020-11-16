package com.bupt.signin;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Leetcode402:移掉K位数字
 * @author Administrator
 */
public class signIn1115 {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();

        int length = num.length();
        for (int i = 0; i < length; i++) {
            char c = num.charAt(i);
            //当且仅当k>0 并且队尾元素大于要入队的元素的时候就把队尾元素移除掉
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > c){
                deque.pollLast();
                k--;
            }
            deque.offerLast(c);
        }
        //此时如果k还大于0，队列里面的元素已经单调不降了，则最后移除队列尾部剩余元素
        //拿123456728 k = 7 举例说明
        //入队完后，队列里面为1228 此时k = 2,所以还需要依次移除队尾2和8，剩余12即为最小
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        boolean flag = true;
        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()){
            Character character = deque.pollFirst();
            //防止前导0
            if (flag && character == '0'){
                continue;
            }
            flag = false;
            stringBuilder.append(character);
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }
}
