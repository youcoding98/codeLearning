package com.bupt.leetcode.binarysearch;

/**
 * Leetcode852:山脉数组的峰顶索引
 * @author Administrator
 */
public class Leetcode852 {
    public static int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int left = 0,right = len - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]){
                return mid;
            }else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]){
                right = mid;
            }else if(arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]){
                left = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,1};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
