package com.bupt.leetcode.twopoints;

/**
 * Leetcode125:验证回文串
 * @author Administrator
 */
public class Leetcode125 {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                sb.append(s.charAt(i));
            }else if (s.charAt(i) >= 65 && s.charAt(i) <= 90){
                sb.append(s.charAt(i));
            }else if (s.charAt(i) >= 97 && s.charAt(i) <= 122){
                char c = (char) (s.charAt(i) - 32);
                sb.append(c);
            }
        }
        String newString = sb.toString();
        int i = 0;
        int j = newString.length() - 1;
        while (i < j){
            if (newString.charAt(i) != newString.charAt(j)){
                flag = false;
                break;
            }
            i++;
            j--;
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
