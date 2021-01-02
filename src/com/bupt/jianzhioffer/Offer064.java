package com.bupt.jianzhioffer;

/**
 * Offer064:求1+2+…+n
 * @author Administrator
 */
public class Offer064 {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n-1)) > 0;
        return n ;
    }
}
