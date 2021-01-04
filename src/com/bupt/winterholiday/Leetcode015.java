package com.bupt.winterholiday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode015：三数之和
 * @author gy
 */
public class Leetcode015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length;i++){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && i < nums.length - 1 &&  nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(right > left && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return result;
    }
}
