package com.bupt.leetcode.array;

/**
 * Leetcode1470:重新排列数组
 * @author Administrator
 */
public class Leetcode1470 {
    public static int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < 2 * n; i++) {
            if (nums[i] > 0){
                //j描述当前nums[i]对应的索引
                int j = i;
                while (nums[i] > 0){
                    //计算j索引的元素
                    if (j < n){
                        j = 2 * j;
                    }else{
                        j = 2 * (j - n) + 1;
                    }
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;

                    nums[j] = -nums[j];
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        System.out.println(shuffle(nums,3));
    }

}
