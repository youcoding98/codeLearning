package com.bupt.weeklycontest;

public class W220_1 {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c >= '0' && c <= '9'){
                sb.append(c);
            }
        }
        if (sb.length() <= 3){
            return sb.toString();
        }
        int flag = sb.length() % 3;
        if (flag == 1){
            flag = 4;
        }
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 0; i < sb.length() - flag; i++) {
            char c = sb.charAt(i);
            result.append(c);
            count++;
            if (count % 3 == 0){
                result.append("-");
            }
        }
        if (flag == 0){
            result.deleteCharAt(result.length() - 1);
        }
        if (flag == 2){
            result.append(sb.charAt(sb.length() - 2));
            result.append(sb.charAt(sb.length() - 1));
        }
        if (flag == 4){
            result.append(sb.charAt(sb.length() - 4));
            result.append(sb.charAt(sb.length() - 3));
            result.append("-");
            result.append(sb.charAt(sb.length() - 2));
            result.append(sb.charAt(sb.length() - 1));
        }
        return result.toString();
    }
}
