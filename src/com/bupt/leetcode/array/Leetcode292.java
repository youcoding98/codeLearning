package com.bupt.leetcode.array;

/**
 * Leetcode292:Nim游戏
 * @author liyuemei
 */
public class Leetcode292 {
    public boolean canWinNim(int n) {
        if (n % 4 == 0){
            return false;
        }
        return true;
    }
}
