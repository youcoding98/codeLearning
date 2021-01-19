package com.bupt.winterholiday;

import java.util.Stack;

/**
 * Leetcode042:接雨水
 * @author gy
 */
public class Leetcode042 {
    /**
     * 思路一：暴力解法
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0,rightMax = 0;
            for (int j = 0; j <= i ; j++) {
                leftMax = Math.max(leftMax,height[j]);
            }
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax,height[j]);
            }
            result += Math.min(leftMax,rightMax) - height[i];
        }
        return result;
    }

    /**
     * 思路二：动态规划
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int result = 0;
        if (height == null || height.length == 0){
            return result;
        }
        int len = height.length;
        int[] dpLeft = new int[len];
        int[] dpRight = new int[len];
        dpLeft[0] = height[0];
        dpRight[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            dpLeft[i] = Math.max(dpLeft[i-1],height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            dpRight[i] = Math.max(dpRight[i+1],height[i]);
        }
        for (int i = 1; i < len - 1; i++) {
            result += Math.min(dpLeft[i],dpRight[i]) - height[i];
        }
        return result;
    }

    /**
     * 思路三：双指针
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left <= right) {
            if (leftMax <= rightMax){
                leftMax = Math.max(leftMax,height[left]);
                result += leftMax - height[left];
                left++;
            }else {
                rightMax = Math.max(rightMax,height[right]);
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }

    /**
     * 思路四：单调栈
     * @param height
     * @return
     */
    public int trap4(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int bottomIndex = stack.pop();
                while (!stack.isEmpty() && stack.peek() == height[bottomIndex]){
                    stack.pop();
                }
                if (!stack.isEmpty()){
                    result += Math.min(height[stack.peek()],height[i]) - height[bottomIndex] * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return result;
    }
}
