package com.bupt.jianzhioffer;

import java.awt.image.Kernel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Offer040:最小的K个数
 * @author Administrator
 */
public class Offer040 {
    /**
     * 快排思想求解
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0){
            return new int[]{};
        }
        return quickSort(arr,0,arr.length - 1,k-1);
    }

    public int[] quickSort(int[] nums,int left,int right,int k){
        int j = partition(nums,left,right);
        if (j == k){
            return Arrays.copyOf(nums,j + 1);
        }
        if (j > k){
            return quickSort(nums, left, j - 1, k);
        }else {
            return quickSort(nums, j + 1, right, k);
        }
    }
    /**
     * 快排切分，返回下标j,使得比nums[j]小的数都在j的左边
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums,int left,int right){
        int v = nums[left];
        int i = left,j = right + 1;
        while (true){
            while (++i <= right && nums[i] < v) {

            }
            while (--j >= left && nums[j] > v) {

            }
            if (i >= j){
                break;
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        nums[left] = nums[j];
        nums[j] = v;
        return j;
    }
}
