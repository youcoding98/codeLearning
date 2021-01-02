package com.bupt.jianzhioffer;

/**
 * Offer066:构建乘积数组
 * @author Administrator
 */
public class Offer066 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] B = new int[len];
        //先乘左边的
        for (int i = 0,cur = 1; i < len; i++) {
            B[i] = cur;
            cur *= a[i];
        }
        //再乘右边的
        for (int i = len - 1,cur = 1; i >= 0 ; i--) {
            B[i] *= cur;
            cur *= a[i];
        }
        return B;
    }

}
