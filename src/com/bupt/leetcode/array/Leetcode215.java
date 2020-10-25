package com.bupt.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Leetcode215:数组中的第K大元素
 * @author gy
 */
public class Leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        bucketSort(nums);
        return nums[nums.length - k];
    }

    public static void bucketSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        //桶数量的映射函数
        int bucketNum = (max - min) / arr.length + 1;
        //将整个桶数组用ArrayList表示，每个桶用存放Integer的ArrayList表示
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<>());
        }

        //根据映射函数，将同属于同一个桶的元素放入对应的桶里
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        //对桶进行排序(这里使用了java自带的TimSort算法)
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }

        int index = 0;
        for (ArrayList<Integer> list : bucketArr) {
            for (Integer integer : list) {
                arr[index ++] = integer;
            }
        }
    }
}
