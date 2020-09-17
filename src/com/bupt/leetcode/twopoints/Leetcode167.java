package com.bupt.leetcode.twopoints;

/**
 * Leetcode167：两数之和II输入有序数组
 * @author Administrator
 */
public class Leetcode167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int len = numbers.length;
        int a = 0;
        int b = len - 1;
        while (a < b){
            int sum = numbers[a] + numbers[b];
            if (sum == target){
                result[0] = a + 1;
                result[1] = b + 1;
                return result;
            }else if (sum > target){
                b--;
            }else {
                a++;
            }
        }
        return result;
    }
}
