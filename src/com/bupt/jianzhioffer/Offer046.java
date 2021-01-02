package com.bupt.jianzhioffer;

/**
 * Offer046:把数字翻译成字符串
 * @author Administrator
 */
public class Offer046 {
    public int translateNum(int num) {
        if (num < 10 || (num > 25 && num < 100)){
            return 1;
        }
        if (num >= 10 && num <= 25){
            return 2;
        }
        int len = Integer.toString(num).length();
        String substring = Integer.toString(num).substring(0, 2);
        int subNum = Integer.parseInt(substring);
        if (subNum >= 10 && subNum <= 25){
            String s1 = Integer.toString(num).substring(1, len);
            String s2 = Integer.toString(num).substring(2, len);
            return translateNum(Integer.parseInt(s1)) + translateNum(Integer.parseInt(s2));
        }else {
            String s1 = Integer.toString(num).substring(1, len);
            return translateNum(Integer.parseInt(s1));
        }

    }
}
