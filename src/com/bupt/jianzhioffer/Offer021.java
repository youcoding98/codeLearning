package com.bupt.jianzhioffer;

/**
 * Offer021:调整数组顺序使奇数位于偶数前面
 * @author Administrator
 */
public class Offer021 {
    public int[] exchange(int[] nums) {
        if (nums.length == 1){
            return nums;
        }
        //odd为奇数
        int odd = 0;
        int even = nums.length - 1;
        while (odd < even){
            if (nums[odd] % 2 == 1){
                odd++;
            }
            if (nums[even] % 2 == 0){
                even--;
            }
            if (nums[odd] % 2 == 0 && nums[even] % 2 == 1 && odd < even){
                swap(nums,odd,even);
                odd++;
                even--;
            }
        }
        return nums;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
