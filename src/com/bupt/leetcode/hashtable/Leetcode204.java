package com.bupt.leetcode.hashtable;

import java.util.Arrays;

/**
 * Leetcode204:计数质数
 * @author Administrator
 */
public class Leetcode204 {
    public int countPrimes(int n) {
        int sum = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]){
                for (int j = i * 2; j < n; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (isPrime[i]){
                sum++;
            }

        }
        return sum;
    }

}
