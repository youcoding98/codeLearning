package com.bupt.jianzhioffer;

/**
 * Offer065:不用加减乘除做加法
 * @author Administrator
 */
public class Offer065 {
    public int add(int a, int b) {
        while (b != 0){
            int temp = (a & b) << 1;
            a ^= b;
            b = temp;
        }
        return a;
    }
}
