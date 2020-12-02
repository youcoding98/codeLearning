package com.bupt.signin;

/**
 * Leetcoded321:拼接最大数
 * @author Administrator
 */
public class signIn1202 {

    private int[] findSubNumber(int[] nums,int len){
        int[] subNums = new int[len];
        int cur = 0;
        int rem = nums.length - len;
        for (int i = 0; i < nums.length; i++) {
            while (cur > 0 && rem > 0 && subNums[cur - 1] < nums[i]){
                cur--;
                rem--;
            }
            if (cur < len){
                subNums[cur++] = nums[i];
            }else {
                rem--;
            }
        }
        return subNums;
    }

    private int[] mergeNumber(int[] nums1,int[] nums2){
        int[] result = new int[nums1.length + nums2.length];
        int cur = 0;
        int p1 = 0,p2 = 0;
        while (cur < nums1.length + nums2.length){
            if (compare(nums1,p1,nums2,p2)){
                result[cur++] = nums1[p1++];
            }else {
                result[cur++] = nums2[p2++];
            }
        }
        return result;
    }

    private boolean compare(int[] nums1,int p1,int[] nums2,int p2){
        if (p2 >= nums2.length){
            return true;
        }
        if (p1 >= nums1.length){
            return false;
        }
        if (nums1[p1] > nums2[p2]){
            return true;
        }
        if (nums1[p1] < nums2[p2]){
            return false;
        }
        return compare(nums1, p1 + 1, nums2, p2 + 1);
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[0];
        for (int i = 0; i <= k && i <= nums1.length ; i++) {
            if (k - i >= 0 && k - i <= nums2.length){
                int[] temp = mergeNumber(findSubNumber(nums1,i),findSubNumber(nums2,k-i));

                if (compare(temp,0,result,0)){
                    result = temp;
                }
            }
        }
        return result;
    }
}
