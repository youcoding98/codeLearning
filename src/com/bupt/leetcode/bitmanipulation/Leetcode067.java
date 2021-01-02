package com.bupt.leetcode.bitmanipulation;

/**
 * Leetcode067:二进制求和
 * @author Administrator
 */
public class Leetcode067 {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0){
            return b;
        }
        if (b == null || b.length() == 0){
            return a;
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int c = 0;
        while (i >= 0 || j >= 0){
            if (i >= 0){
                c += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0){
                c += b.charAt(j) - '0';
                j--;
            }
            sb.append(c % 2);
            c /= 2;
        }
        if (c > 0){
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
