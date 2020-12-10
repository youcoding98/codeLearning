package com.bupt.jianzhioffer;

/**
 * Offer020:表示数值的字符串
 * @author Administrator
 */
public class Offer020 {
    public boolean isNumber(String s) {
        if (s.length() == 0 || s == null){
            return false;
        }
        //去除首位空格
        s = s.trim();
        boolean numsFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            //判定为数字，numsFlag为true
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                numsFlag = true;
                //.出现但只能出现一次且在e的前面
            }else if (s.charAt(i) == '.' && !dotFlag && !eFlag){
                dotFlag = true;
                //e只能出现一次且出现前有数字
            }else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numsFlag){
                eFlag = true;
                //避免123e这种情况的出现
                numsFlag = false;
                //+-只能出现在开头和e的后一位
            }else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i-1) == 'e' || s.charAt(i-1) == 'E')){

            }else {
                return false;
            }
        }
        return numsFlag;
    }
}
