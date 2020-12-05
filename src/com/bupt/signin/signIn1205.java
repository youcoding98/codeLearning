package com.bupt.signin;

/**
 * Leetcode621:任务调度器
 * @author gy
 */
public class signIn1205 {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0){
            return tasks.length;
        }
        int[] nums = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            nums[tasks[i] - 'A']++;
        }
        int max = 0;
        for (int num:nums) {
            max = Math.max(max,num);
        }

        int maxCount = 0;
        for (int num:nums) {
            if (num == max){
                maxCount ++;
            }
        }
        return Math.max(tasks.length,(n + 1) * (max - 1) + maxCount);
    }
}
