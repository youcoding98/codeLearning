package com.bupt.leetcode.twopoints;

/**
 * Leetcode826:安排工作以达到最大收益
 * @author Administrator
 */
public class Leetcode826 {
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int result = 0;
        if (worker.length == 0 || worker == null){
            return result;
        }
        for (int i = 0; i < worker.length; i++) {
            int left = 0;
            int right = difficulty.length - 1;
            int maxProfit = 0;
            while (left <= right){
                if (difficulty[left] <= worker[i]){
                    maxProfit = Math.max(maxProfit,profit[left]);
                }
                if (difficulty[right] <= worker[i]){
                    maxProfit = Math.max(maxProfit,profit[right]);
                }
                left++;
                right--;
            }
            result += maxProfit;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};
        System.out.println(maxProfitAssignment(difficulty,profit,worker));
    }
}
