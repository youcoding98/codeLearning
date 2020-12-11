package com.bupt.signin;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Leetcode649:Dota2 参议院
 * @author Administrator
 */
public class signIn1211 {
    public String predictPartyVictory(String senate) {
        if (senate.length() == 1){
            if (senate.charAt(0) == 'R'){
                return "Radiant";
            }else {
                return "Dire";
            }
        }
        int len = senate.length();
        Queue<Integer> queueR = new LinkedList<>();
        Queue<Integer> queueD = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char c = senate.charAt(i);
            if (c == 'R'){
                queueR.offer(i);
            }else if (c == 'D'){
                queueD.offer(i);
            }
        }
        while (!queueD.isEmpty() && !queueR.isEmpty()){
            int DIndex = queueD.poll();
            int RIndex = queueR.poll();
            if (DIndex > RIndex){
                queueR.offer(RIndex + len);
            }else {
                queueD.offer(DIndex + len);
            }
        }
        if (queueD.isEmpty()){
            return "Radiant";
        }else {
            return "Dire";
        }

    }
}
