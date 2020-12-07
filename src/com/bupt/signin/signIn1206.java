package com.bupt.signin;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode118:杨辉三角
 * @author gy
 */
public class signIn1206 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0){
            return result;
        }
        int[][] nums = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            nums[i][0] = 1;
            if (i > 0){
                for (int j = 1; j < numRows; j++) {
                    nums[i][j] = nums[i-1][j] + nums[i-1][j-1];
                }
            }
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < numRows; j++) {
                if (nums[i][j] != 0){
                    list.add(nums[i][j]);
                }
            }
            result.add(list);
        }
        return result;
    }
}
