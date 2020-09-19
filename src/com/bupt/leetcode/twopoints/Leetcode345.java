package com.bupt.leetcode.twopoints;

import java.util.Arrays;
import java.util.HashMap;

/**
 *Leetcode345:反转字符串中的元音字母
 * @author Administrator
 */
public class Leetcode345 {
    public String reverseVowels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('a',1);
        map.put('e',1);
        map.put('i',1);
        map.put('o',1);
        map.put('u',1);
        map.put('A',1);
        map.put('E',1);
        map.put('I',1);
        map.put('O',1);
        map.put('U',1);
        int i = 0;
        int j = s.length() - 1;
        char[] nums = s.toCharArray();
        while (i < j){
            if (map.containsKey(s.charAt(i))){
                if (map.containsKey(s.charAt(j))){
                    char temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j--;
                }else{
                    j--;
                }
            }else {
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < s.length(); k++) {
            sb.append(nums[k]);
        }
        return sb.toString();
    }
}
