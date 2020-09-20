package com.bupt.weeklycontest;

/**
 * D035_1:所有奇数长度子数组的和
 * @author Administrator
 */
public class D035_1 {
    public int sumOddLengthSubarrays(int[] arr) {
        int result = 0;
        if (arr.length == 0 || arr == null){
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            int j = i + 2;
            int k = i;
            while (j < arr.length){
                k = i;
                while (k <= j){
                    result += arr[k];
                    k++;
                }
                j = j + 2;
            }
        }
        return result;
    }
}
