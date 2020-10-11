package com.bupt.signin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Leetcode416:分割等和子集
 * @author gy
 */
public class signIn1011 {
    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length ==  0){
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1){
            return false;
        }
        int result = sum / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == result){
                return true;
            }
            if (set.contains(result-nums[i])){
                return true;
            }
            List<Integer> list = new ArrayList<>(set);
            for (int j = 0; j < list.size(); j++) {
                int temp = list.get(j) + nums[i];
                set.add(temp);
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,7};
        if (canPartition(nums)){
            System.out.println("1");
        }else {
            System.out.println("2");
        }
    }
}
