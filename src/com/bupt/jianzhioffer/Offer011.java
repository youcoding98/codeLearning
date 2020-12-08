package com.bupt.jianzhioffer;

/**
 * Offer011:旋转数组的最小数字
 * @author Administrator
 */
public class Offer011 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (numbers[right] > numbers[mid]){
                right = mid;
            }else if (numbers[right] < numbers[mid]){
                left = mid + 1;
            }else {
                right--;
            }
        }
        return numbers[left];
    }
}
