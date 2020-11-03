package com.bupt.leetcode.binarysearch;

/**
 * Leetcode374:猜数字大小
 * @author Administrator
 */
class GuessGame {

    private static final int NUM = 6;

    int guess(int num) {
        if (num == NUM) {
            return 0;
        } else if (num < NUM) {
            return -1;
        }
        return 1;
    }
}

public class Leetcode374 extends GuessGame {
    public int guessNumber(int n) {
        int left = 0;
        int right = n - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            int guessNum = guess(mid);
            if (guessNum == -1){
                right = mid - 1;
            }else if (guessNum == 1){
                left = mid + 1;
            }else if (guessNum == 0){
                right = mid - 1;
            }
        }
        return left;
    }
}
