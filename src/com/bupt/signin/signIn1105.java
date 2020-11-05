package com.bupt.signin;

import java.util.*;

/**
 * Leetcode127:单词接龙
 * @author Administrator
 */
public class signIn1105 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 0;
        Deque<String> deque = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            set.add(s);
        }
        deque.offerLast(beginWord);
        while (!deque.isEmpty()){
            Deque<String> deque1 = new LinkedList<>();
            while (!deque.isEmpty()){
                String s1 = deque.removeFirst();
                for (int i = 0; i < wordList.size(); i++) {
                    String s = wordList.get(i);
                    if (set.contains(s)){
                        if (isChangeWord(s1,s)){
                            set.remove(s);
                            deque1.add(s);
                            if (s.equals(endWord)){
                                return result + 2;
                            }
                        }
                    }
                }
            }
            deque = deque1;
            result++;
        }
        return 0;
    }

    public boolean isChangeWord(String s1,String s2){
        if (s1.length() != s2.length()){
            return false;
        }
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                count++;
            }
        }
        if (count == 1){
            return true;
        }
        return false;
    }


}
