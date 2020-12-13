package com.bupt.jianzhioffer;

/**
 * Offer043:1~n整数中1出现的次数
 * @author gy
 */
public class Offer043 {
    public int countDigitOne(int n) {
        return f(n);
    }

    public int f(int n){
        if (n <= 0){
            return 0;
        }
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int)Math.pow(10,s.length() - 1);
        int last = n - high * pow;
        if (high == 1){
            return f(pow - 1) + f(last) + last + 1;
        }else {
            return high * f(pow - 1) + f(last) + pow;
        }
    }
}
