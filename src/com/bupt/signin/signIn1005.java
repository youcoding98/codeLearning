package com.bupt.signin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode018:四数之和
 * @author Administrator
 */
public class signIn1005 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4 || nums == null){
            return result;
        }
        Arrays.sort(nums);
        for (int a = 0; a < nums.length; a++) {
            if (a > 0 && nums[a] == nums[a-1]){
                continue;
            }
            for (int b = a + 1; b < nums.length; b++) {
                if (b > a+1 && nums[b] == nums[b-1]){
                    continue;
                }
                int i = b + 1;
                int j = nums.length - 1;
                while (i < j){
                    int sum = nums[a] + nums[b] + nums[i] + nums[j];
                    if (sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        result.add(list);
                        while (i < j && nums[i] == nums[i + 1]){
                            i++;
                        }
                        while (i < j && nums[j] == nums[j - 1]){
                            j--;
                        }
                        i++;
                        j--;
                    }else if (sum < target){
                        i++;
                    }else if (sum > target){
                        j--;
                    }
                }
            }
        }
        return result;
    }
}
