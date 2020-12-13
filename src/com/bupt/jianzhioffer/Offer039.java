package com.bupt.jianzhioffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Offer039:数组中出现次数超过一半的数字
 * @author gy
 */
public class Offer039 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer card = null;
        for (int num:nums) {
            if (count == 0){
                card = num;
            }
            if (card == num){
                count += 1;
            }else {
                count += -1;
            }
        }
        return card;
    }
}
