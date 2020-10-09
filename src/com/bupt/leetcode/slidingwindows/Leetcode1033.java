package com.bupt.leetcode.slidingwindows;

import java.util.Arrays;

/**
 * Leetcode1033:移动石子直到连续
 * @author Administrator
 */
public class Leetcode1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[]{a,b,c};
        Arrays.sort(arr);
        int[] result = new int[2];
        if (arr[1] - arr[0] == 1 && arr[2] - arr[1] == 1){
            result[0] = 0;
        }else if (arr[1] - arr[0] == 1 || arr[2] - arr[1] == 1|| arr[2] - arr[1] == 2 || arr[1] - arr[0] == 2){
            result[0] = 1;
        }else{
            result[0] = 2;
        }
        result[1] = arr[2] - arr[0] - 2;
        return result;
    }
}
