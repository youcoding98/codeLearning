package com.bupt.jianzhioffer;

/**
 * Offer016:数值的整数次方
 * @author Administrator
 */
public class Offer016 {
    public double myPow(double x, int n) {
        if (n == 0){
            return 1.0;
        }
        if (n == 1){
            return x;
        }
        if (n == -1) {
            return 1/x;
        }
        double half = myPow(x,n / 2);
        double mod = myPow(x,n % 2);
        return half * half * mod;
    }
}
