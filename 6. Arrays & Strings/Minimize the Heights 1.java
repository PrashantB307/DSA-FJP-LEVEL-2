

//    https://practice.geeksforgeeks.org/problems/minimize-the-heights-i/1

//    https://www.codingninjas.com/studio/problems/minimize-the-maximum_696194


import java.util.*;
class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        
        Arrays.sort(arr);
        int largest = arr[n - 1] - k;
        int smallest = arr[0] + k;
        int diff = arr[n - 1] - arr[0];
       
        int min, max;
        
        for(int i = 0; i < n - 1; i++){
            min = Math.min(smallest, arr[i + 1] - k);
            max = Math.max(largest, arr[i] + k);
           
            diff  = Math.min(diff, max - min);
        }
        
        return diff;
    }
}