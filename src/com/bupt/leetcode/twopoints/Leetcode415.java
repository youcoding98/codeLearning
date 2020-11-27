package com.bupt.leetcode.twopoints;

/**
 * Leetcode415:字符串相加
 * @author Administrator
 */
public class Leetcode415 {
    public String addStrings(String num1, String num2) {
        if (num1.length() == 0 || num1 == null){
            return num2;
        }
        if (num2.length() == 0 || num2 == null){
            return num1;
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length()-1, j = num2.length()-1;
        while(i >= 0 || j >= 0 || carry != 0){
            if(i>=0) carry += num1.charAt(i--)-'0';
            if(j>=0) carry += num2.charAt(j--)-'0';
            sb.append(carry%10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}
