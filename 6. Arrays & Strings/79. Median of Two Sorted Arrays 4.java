

//     https://leetcode.com/problems/median-of-two-sorted-arrays/

//     https://practice.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1


import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;

        int m1 = (m + n + 1) / 2;
        int m2 = (m + n + 2) / 2;

        int median1 = getKthElement(nums1, nums2, m1, 0, 0);
        int median2 = getKthElement(nums1, nums2, m2, 0, 0);

        return (median1 + median2) / 2.0;
    }

    public int getKthElement(int[] nums1, int[] nums2, int k, int s1, int s2){

        if(s1 >= nums1.length){
            return nums2[s2 + k - 1];
        }

        if(s2 >= nums2.length){
            return nums1[s1 + k - 1];
        }

        if(k == 1){
            return Math.min(nums1[s1], nums2[s2]);
        }

        int el1 = Integer.MAX_VALUE;
        if(s1 + k / 2 - 1 < nums1.length){
            el1 = nums1[s1 + k / 2 - 1];
        }

        int el2 = Integer.MAX_VALUE;
        if(s2 + k / 2 - 1 < nums2.length){
            el2 = nums2[s2 + k / 2 - 1];
        }

        if(el1 < el2){
            return getKthElement(nums1, nums2, k - k / 2, s1 + k / 2, s2);
        }else{
            return getKthElement(nums1, nums2, k - k / 2, s1, s2 + k / 2);
        }
    }
}


// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        int []arr = new int[m + n];

        System.arraycopy(a, 0, arr, 0, n);
        System.arraycopy(b, 0, arr, n, m);

        Arrays.sort(arr);

        if(arr.length % 2 == 0){
           double ans = (double)(arr[arr.length / 2] + arr[(arr.length / 2) - 1]) / 2;
           return ans;
        }else{
            return (double)arr[arr.length / 2];
        }
    }
}