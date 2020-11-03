package com.bupt.leetcode.binarysearch;

/**
 * Leetcode287:寻找重复数
 * @author Administrator
 */
public class Leetcode287 {
    /**
     * 快慢指针方法
     * @param nums
     * @return
     */
    public static int findDuplicate1(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0;
        int pre2 = slow;
        while (pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }

    /**
     * 二分查找
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num:nums) {
                if (num <= mid){
                    count++;
                }
            }

            if (count > mid){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        findDuplicate(nums);
    }
}
