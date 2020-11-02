package com.bupt.signin;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Leetcode349:两个数组的交集
 * @author Administrator
 */
public class signIn1102 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return new int[]{};
        }
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!set1.contains(nums1[i])){
                set1.add(nums1[i]);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i]) && !set2.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }
        Iterator<Integer> iterator = set2.iterator();
        int[] result = new int[set2.size()];
        int j = 0;
        while (iterator.hasNext()){
            Integer key = iterator.next();
            result[j++] = key;
        }
        return result;
    }
}
