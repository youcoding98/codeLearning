package com.bupt.leetcode.array;

/**
 * Leetcode043:字符串相乘
 * @author gy
 */
public class Leetcode043 {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        int[] result = new int[n1 + n2];
        for (int i = n1-1; i >= 0; i--) {
            for (int j = n2-1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int ten = i + j + 1;
                int zero = i + j;
                int sum = mul + result[ten];
                result[ten] = sum % 10;
                result[zero] += sum / 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0 && i == 0){
                continue;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        multiply("2","3");
    }
}

