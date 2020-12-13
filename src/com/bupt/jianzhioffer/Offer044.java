package com.bupt.jianzhioffer;

/**
 * Offer044:数字序列中某一位的数字
 * @author gy
 */
public class Offer044 {
    public int findNthDigit(int n) {
        //n所在数字的位数
        int digit = 1;
        //数字范围开始的第一个数
        long start = 1;
        //占多少位
        long count = 9;
        while (n > count){
            n -= count;
            digit++;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1)/digit;
        int index = (n - 1) % digit;
        return Long.toString(num).charAt(index) - '0';
    }
}
