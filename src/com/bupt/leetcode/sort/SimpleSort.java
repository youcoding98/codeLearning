package com.bupt.leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author gy
 */
public class SimpleSort {

    public static void main(String[] args) {
        int[] arr = {1,1,2,0,9,3,12,7,8,3,4,65,22};
        countSort(arr);
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
    public static void heapSort(int[] nums){

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
