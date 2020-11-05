package com.bupt.leetcode.binarysearch;

/**
 * Leetcode1095:山脉数组中查找目标值
 * @author Administrator
 */
public class Leetcode1095 {
    interface MountainArray {
        public int get(int index);

        public int length();
    }


    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0,right = mountainArr.length() - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        int peakIndex = left;
        int leftIndex = findLeftMountain(target,0,peakIndex,mountainArr);
        if (leftIndex != -1){
            return leftIndex;
        }
        return findRightMountain(target,peakIndex + 1, mountainArr.length() - 1,mountainArr);

    }

    public int findLeftMountain(int target,int left,int right,MountainArray mountainArr){
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < target){
                left = mid + 1;
            }else if (mountainArr.get(mid) > target){
                right = mid - 1;
            }else if (mountainArr.get(mid) == target){
                return mid;
            }
        }
        return -1;
    }

    public int findRightMountain(int target,int left,int right,MountainArray mountainArr){
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < target){
                right = mid - 1;
            }else if (mountainArr.get(mid) > target){
                left = mid + 1;
            }else if (mountainArr.get(mid) == target){
                return mid;
            }
        }
        return -1;
    }



}
