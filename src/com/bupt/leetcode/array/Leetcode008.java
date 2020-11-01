package com.bupt.leetcode.array;

/**
 * Leetcode008:字符串转化为整数
 * @author gy
 */
public class Leetcode008 {
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0){
            return 0;
        }
        int i = 0;
        //去除头部空格
        for (i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' '){
                break;
            }
        }
        if (i == str.length()){
            return 0;
        }
        //对首字母进行判断
        int isPlus = 1;
        char c = str.charAt(i);
        if (c == '-'){
            isPlus = -1;
            i++;
        }else if (c == '+'){
            isPlus = 1;
            i++;
        }else if (c >= '0' && c <= '9'){
            isPlus = 1;
        }else {
            return 0;
        }
        int sum = 0;
        while (i < str.length()){
            char temp = str.charAt(i);
            if (temp < '0' || temp > '9'){
                break;
            }

            if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && (temp - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && (temp - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            sum = sum * 10 + isPlus * (temp - '0');

            i++;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("9223372036854775808"));
    }
}
