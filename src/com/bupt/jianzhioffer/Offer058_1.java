package com.bupt.jianzhioffer;

/**
 * Offer058_1:翻转单词顺序
 * @author Administrator
 */
public class Offer058_1 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        String[] s1 = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].equals("")){
                continue;
            }
            if (i == 0){
                sb.append(s1[i].trim());
            }else {
                sb.append(s1[i].trim()).append(" ");
            }
        }
        return sb.toString();
    }
}
