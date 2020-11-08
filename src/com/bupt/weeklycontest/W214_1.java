package com.bupt.weeklycontest;

import java.util.Arrays;

public class W214_1 {
    public static int getMaximumGenerated(int n) {
        if (n == 0){
            return 0;
        }
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 1; i <= n / 2; i++) {
            if (i * 2 <= n){
                result[i * 2] = result[i];
            }
            if (i * 2 + 1<= n){
                result[i * 2 + 1] = result[i] + result[i + 1];
            }
        }
        Arrays.sort(result);
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(3));
    }
}
