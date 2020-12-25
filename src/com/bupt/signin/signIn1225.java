package com.bupt.signin;

import java.util.Arrays;

/**
 * Leetcode455：分发饼干
 * @author Administrator
 */
public class signIn1225 {
    public static int findContentChildren(int[] g, int[] s) {
        if (s == null || s.length == 0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < s.length && j < g.length){
            if (s[i] >= g[j]){
                i++;
                j++;
            }else if (s[i] < g[j]){
                i++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};
        findContentChildren(g,s);
    }
}
