package com.bupt.jianzhioffer;

/**
 * Offer015:二进制中1的个数
 * @author Administrator
 */
public class Offer015 {
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0){
            result++;
            n = n & (n-1);
        }
        return result;
    }
}
