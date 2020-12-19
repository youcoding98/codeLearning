package com.bupt.jianzhioffer;

import org.omg.CORBA.INTERNAL;

/**
 * Offer061:扑克牌中的顺子
 * @author Administrator
 */
public class Offer061 {
    public boolean isStraight(int[] nums) {
        int[] cards = new int[14];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                continue;
            }

            if (cards[nums[i]] >= 1){
                return false;
            }
            cards[nums[i]]++;
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }

        return max - min <= 4;
    }
}
