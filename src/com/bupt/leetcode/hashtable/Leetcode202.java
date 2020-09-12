package com.bupt.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Leetcode202:快乐数
 * @author Administrator
 */
public class Leetcode202 {
    HashSet<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        if (n == 1){
            return true;
        }
        if (n == 0){
            return false;
        }

        int sum = 0;
        while (n >= 10){
            sum = sum + (n % 10) * (n % 10);
            n = n / 10;
        }
        sum += n*n;
        if (sum == 1){
            return true;
        }else if (set.contains(sum)){
            return false;
        }else {
            set.add(sum);

        }
        return isHappy(sum);
    }
}
