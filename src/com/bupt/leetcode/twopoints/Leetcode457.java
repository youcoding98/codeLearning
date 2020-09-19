package com.bupt.leetcode.twopoints;

/**
 * Leetcode457:环形数组循环
 * @author Administrator
 */
public class Leetcode457 {
    public static boolean circularArrayLoop(int[] nums) {
        int[] trip = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (trip[i] == 2){
                continue;
            }
            if (nums[i] % nums.length == 0){
                trip[i] = 2;
                continue;
            }
            boolean right = nums[i] > 0;
            int index = i;
            while (true){
                if (nums[index] > 0 != right){
                    break;
                }
                if (trip[index] == 2){
                    break;
                }
                if (nums[index] % nums.length == 0){
                    trip[index] = 2;
                    break;
                }
                trip[index] = 1;
                index = (index + (nums[index] % nums.length) + nums.length) % nums.length;
                if (trip[index] == 1){
                    return true;
                }
            }
            index = i;
            while (trip[index] == 1){
                trip[index] = 2;
                index = (index + (nums[index] % nums.length) + nums.length) % nums.length;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,-1,1,2,2};
        circularArrayLoop(nums);
    }
}
