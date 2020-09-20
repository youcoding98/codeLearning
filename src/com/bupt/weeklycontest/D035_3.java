package com.bupt.weeklycontest;

import java.util.HashMap;

/**
 * D035_3:使数组和能被P整除
 * @author Administrator
 */
public class D035_3 {
    public static int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % p == 0){
            return 0;
        }
        long r = sum % p;
        long[] preSums = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSums[i] = preSums[i-1] + nums[i-1];
        }
        int min = Integer.MAX_VALUE;
        //哈希表保存上个前缀和的位置
        HashMap<Long,Integer> preSumMap = new HashMap<>();
        for (int i = 0; i <= nums.length; i++) {
            Integer index = preSumMap.get((preSums[i] - r) % p);
            if (index != null) {
                min = Math.min(min, i - index);
            }
            preSumMap.merge(preSums[i] % p, i, Math::max);

        }
        return (min == Integer.MAX_VALUE || min == nums.length) ? -1 : min;

    }

    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000};
        System.out.println(minSubarray(nums,3));
    }
}
