

//     https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1

//     https://www.codingninjas.com/studio/problems/k-th-element-of-2-sorted-array_1164159?leftPanelTab=0


import java.util.*;
class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        int []arr = new int[n + m];

        System.arraycopy(arr1, 0, arr, 0, n);
        System.arraycopy(arr2, 0, arr, n, m);

        Arrays.sort(arr);
        
        return arr[k - 1];
    }
}