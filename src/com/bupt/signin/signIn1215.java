package com.bupt.signin;

/**
 * Leetcode738：单调递增的数字
 * @author Administrator
 */
public class signIn1215 {
    public static int monotoneIncreasingDigits(int N) {
        if (N < 10){
            return N;
        }
        String s = String.valueOf(N);
        int len = s.length();
        char[] charArray = s.toCharArray();
        int flag = len;
        for (int i = len - 1; i > 0; i--) {
            if (charArray[i - 1] > charArray[i]){
                charArray[i-1]--;
                flag = i;
            }
        }
        for (int i = flag; i < len; i++) {
            charArray[i] = '9';
        }
        String s1 = new String(charArray);
        return Integer.parseInt(s1);
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(768887));
    }
}
