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
     * @param arr
     */

    public static void heapSort(int [] arr){
        //1.构建大顶堆
        for(int i = arr.length / 2 - 1;i >= 0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j = arr.length - 1;j > 0;j--){
            //将堆顶元素与末尾元素进行交换
            swap(arr,0,j);
            //重新对堆进行调整
            adjustHeap(arr,0,j);
        }
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
    public static void adjustHeap(int []arr,int i,int length){
        //先取出当前元素i
        int temp = arr[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for(int k = i * 2 + 1;k < length;k = k * 2 + 1){
            //如果左子结点小于右子结点，k指向右子结点
            if(k+1 < length && arr[k] < arr[k+1]){
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        //将temp值放到最终的位置
        arr[i] = temp;
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
