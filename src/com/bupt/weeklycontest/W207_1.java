package com.bupt.weeklycontest;

import java.util.ArrayList;
import java.util.List;

/**
 * W207_1:重新排列单词间的空格
 * @author Administrator
 */
public class W207_1 {
    public  static String reorderSpaces(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' '){
                count++;
            }

        }
        if (count == 0){
            return text;
        }
        int i = 0;
        List<String> list = new ArrayList<>();
        while (i < text.length()){
            if (text.charAt(i) != ' '){
                int start = i;
                while (text.charAt(i) != ' ' && i < text.length()){
                    i++;
                    if (i == text.length()){
                        break;
                    }
                }
                int end = i;
                String s1 = text.substring(start,end);
                list.add(s1);
            }
            i++;
        }
        int mid = 0;
        int more = 0;
        if (list.size() > 1){
            mid = count / (list.size() - 1);
            more = count % (list.size() - 1);
        }else {
            mid = 0;
            more = count;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < list.size(); j++) {
            sb.append(list.get(j));
            if (j != list.size() - 1){
                for (int k = 0; k < mid; k++) {
                    sb.append(' ');
                }
            }

        }
        for (int j = 0; j < more; j++) {
            sb.append(' ');
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(reorderSpaces("  hello"));
    }
}
