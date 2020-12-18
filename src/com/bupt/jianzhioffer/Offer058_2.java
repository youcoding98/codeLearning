package com.bupt.jianzhioffer;

/**
 * Offer058_2:左旋转字符串
 * @author Administrator
 */
public class Offer058_2 {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        String sLeft = s.substring(0, n);
        String sRight = s.substring(n, len);
        return sRight + sLeft;
    }
}
