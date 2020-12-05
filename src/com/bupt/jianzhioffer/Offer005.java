package com.bupt.jianzhioffer;

/**
 * Offer005:替换空格
 * @author gy
 */
public class Offer005 {
    public String replaceSpace(String s) {
        if (s.length() == 0 || s == null){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
