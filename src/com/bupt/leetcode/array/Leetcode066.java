package com.bupt.leetcode.array;

/**
 * Leetcode066:加一
 * @author Administrator
 */
public class Leetcode066 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9){
                if (i == 0){
                    int[] temp = new int[len + 1];
                    temp[0] = 1;
                    return temp;
                }else {
                    digits[i] = 0;
                }
            }else {
                digits[i]++;
                break;
            }
        }
        return digits;
    }
}
