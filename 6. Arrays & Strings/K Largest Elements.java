  


//    https://practice.geeksforgeeks.org/problems/k-largest-elements4206/1

//    https://www.codingninjas.com/studio/problems/k-largest-element_1062624?leftPanelTab=0


import java.util.*;
class Solution {
    int[] kLargest(int[] arr, int n, int k) {
       Arrays.sort(arr);
       
       Stack<Integer> st = new Stack<>();
       for(int val : arr){
           st.add(val);
       }
       
       int[] ans = new int[k];
       
       for(int i = 0; i < k; i++){
           ans[i] = st.pop();
       }
       
       return ans;
    }
}