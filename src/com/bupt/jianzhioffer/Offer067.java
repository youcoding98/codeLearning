package com.bupt.jianzhioffer;

/**
 * Offer067:字符串转化为整数
 * @author Administrator
 */
public class Offer067 {
    public int myAtoi(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        //1、去除前导空格
        for (i = 0; i < s.length(); i++) {
            if (c[i] != ' '){
                break;
            }
        }
        //是不是全是空格
        if (i == s.length()){
            return 0;
        }
        //2、判断正负号
        boolean negative = false;
        if (c[i] == '-'){
            negative = true;
            i++;
        }else if (c[i] == '+'){
            i++;
        }else if (c[i] >= '0' && c[i] <= '9'){
            negative = false;
        }else {
            return 0;
        }
        //3、识别数字，注意越界情况
        int ans = 0;
        while (i < s.length() && (c[i] >= '0' && c[i] <= '9')){
            int digit = c[i] - '0';
            //判断是否越界
            if (ans > (Integer.MAX_VALUE - digit) / 10){
                if (negative){
                    return Integer.MIN_VALUE;
                }else {
                    return Integer.MAX_VALUE;
                }
            }
            ans = ans * 10 + digit;
            i++;
        }
        if (negative){
            return -ans;
        }else {
            return ans;
        }
    }
}
