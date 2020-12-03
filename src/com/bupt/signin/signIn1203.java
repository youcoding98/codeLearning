package com.bupt.signin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode204:计数质数
 * @author Administrator
 */
public class signIn1203 {
    public int countPrimes(int n) {
        if (n < 2){
            return 0;
        }
        int count = 0;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime,true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]){
                count++;
                for (int j = 2; i * j < n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        return count;
    }
}
