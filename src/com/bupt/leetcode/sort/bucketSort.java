package com.bupt.leetcode.sort;

import com.bupt.signin.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序原理调试
 */
public class bucketSort {
    public static void bucketSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i],max);
            min = Math.min(arr[i],min);
        }
        //桶数量的映射函数
        int bucketNum = (max - min) / arr.length + 1;
        List<List<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<>());
        }
        //根据映射函数，将同属同一个桶的元素放入对应的桶里
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }

        int index = 0;
        for (List<Integer> list: bucketArr) {
            for (Integer integer: list) {
                arr[index++] = integer;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1,4,3,12};
        bucketSort(arr);
    }
}
