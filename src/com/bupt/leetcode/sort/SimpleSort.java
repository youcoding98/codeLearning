package com.bupt.leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author gy
 */
public class SimpleSort {

    public static void main(String[] args) {
        int[] arr = {4,9,3,7,1};
        heapSort(arr);
        for (int i:arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public static void bubbleSort(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len - i; j++) {
                if (nums[j-1] > nums[j]){
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param nums
     */
    public static void selectionSort(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int minFlag = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minFlag]){
                    minFlag = j;
                }
            }
            if (minFlag != i){
                int temp = nums[minFlag];
                nums[minFlag] = nums[i];
                nums[i] = temp;
            }
        }
    }

    /**
     * 插入排序
     * @param nums
     */
    public static void insertionSort(int[] nums){
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j-1] > temp){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
    }

    /**
     * 归并排序
     * @param nums
     */
    public static void mergeSort(int[] nums){
        sortMerge(nums,0,nums.length - 1);
    }

    public static void sortMerge(int[] nums,int left,int right){
        int mid = (left + right) / 2;
        if (left < right){
            sortMerge(nums, left, mid);
            sortMerge(nums, mid + 1, right);
            mergeArray(nums,left,mid,right);
        }
    }

    public static void mergeArray(int[] nums,int left,int mid,int right){
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right){
            if (nums[i] < nums[j]){
                temp[k] = nums[i++];
            }else {
                temp[k] = nums[j++];
            }
            k++;
        }
        while (i <= mid){
            temp[k++] = nums[i++];
        }
        while (j <= right){
            temp[k++] = nums[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            nums[left + l] = temp[l];
        }
    }

    /**
     * 快速排序
     * @param nums
     */
    public static void quickSort(int[] nums){
        sort(nums,0,nums.length - 1);
    }

    public static void sort(int[] nums,int left,int right){
        if (left < right){
            int mid = partition(nums,left,right);
            sort(nums,left,mid-1);
            sort(nums,mid+1,right);
        }
    }

    public static int partition(int[] nums,int left,int right){
        //确定快排的基准元素
        int middle = nums[left];
        while (left < right){
            while (left < right && nums[right] > middle){
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= middle){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = middle;
        return left;
    }

    /**
     * 堆排序
     * @param nums
     */
    private static void heapSort(int[] nums) {
        int len = nums.length;
        //将乱序数组调整为大根堆
        for (int i = len / 2 - 1; i > -1; --i) {
            heapAdjust(nums, i, len);
        }
        //元素出堆、循环堆调整
        for (int i = len - 1; i > 0; --i) {
            //交换i和0两个元素，使用位运算完成
            swap(nums, i, 0);
            //堆调整
            heapAdjust(nums, 0, i);
        }
        //arr排序完毕
    }
    /**
     * 交换数组中两个数，使用位运算
     */
    private static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
    /**
     * 堆调整
     */
    private static void heapAdjustOld(int[] arr, int s, int length) {
        for (int i = 2 * s + 1; i < length; i = 2 * i + 1) {
            if (i + 1 < length && arr[i + 1] > arr[i]) {
                ++i;
            }
            if (arr[s] > arr[i]) {
                break;
            }
            swap(arr, s, i);
            s = i;
        }

    }
    /**
     * 堆调整优化方法
     */
    private static void heapAdjust(int[] arr, int s, int length) {
        int temp = arr[s];
        for (int j = 2 * s + 1; j < length; j =  j * 2 + 1) {
            if (j + 1 < length && arr[j + 1] > arr[j]) {
                ++j;
            }
            if (temp > arr[j]) {
                break;
            }
            arr[s] = arr[j];
            s = j;
        }
        arr[s] = temp;
    }

    /**
     * 计数排序
     * @param arr
     */
    public static void countSort(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        //创建临时数组
        int[] temp = new int[max - min + 1];
        //计数
        for (int i = 0; i < len; i++) {
            temp[arr[i] - min] = temp[arr[i] - min] + 1;
        }

        //将临时数组中的数据依次放入原数组
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            int num = temp[i];
            while (num != 0){
                arr[index++] = i + min;
                num--;
            }
        }
    }

    /**
     * 桶排序
     * @param arr
     */
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
