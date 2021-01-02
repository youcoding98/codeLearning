package com.bupt.jianzhioffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Offer059_1:滑动窗口的最大值
 * @author Administrator
 */
public class Offer059_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int left = 0, right = 0;
        while (right < nums.length){
            if (!queue.isEmpty() && queue.peek() <= right - k){
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[right]){
                queue.removeLast();
            }
            queue.addLast(right);
            if (right >= k - 1){
                list.add(nums[queue.peek()]);
            }
            right++;
        }
        int[] result = new int[list.size()];
        int index = 0;
        for (int num:list) {
            result[index++] = num;
        }
        return result;
    }
}
