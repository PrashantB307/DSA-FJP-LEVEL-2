

//    https://www.geeksforgeeks.org/problems/maximum-of-minimum-for-every-window-size3453/1


import java.util.*;
class Solution 
{
   
    static int[] maxOfMin(int[] arr, int n) 
    {
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n]; 

        Stack<Integer> st1 = new Stack<>();
        for(int i = 0; i < n; i++){
            while (!st1.isEmpty() && arr[st1.peek()] >= arr[i]) {
                st1.pop();
            }

            if(st1.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = st1.peek();
            }

            st1.push(i);
        }

        Stack<Integer> st2 = new Stack<>();
        for(int i = n -1; i >= 0; i--){
            while (!st2.isEmpty() && arr[st2.peek()] >= arr[i]) {
                st2.pop();
            }

            if(st2.isEmpty()){
                right[i] = n;
            }else{
                right[i] = st2.peek();
            }

            st2.push(i);
        }

        for(int i = 0; i < n; i++){
            int idx = right[i] - left[i] - 1;
            if(arr[i] > ans[idx - 1]){
                ans[idx - 1] = arr[i];
            }
        }

        int max = ans[n - 1];
        for(int i = n - 2; i >= 0; i--){
            max = Math.max(max, ans[i]);
            ans[i] = max;
        }

        return ans;
    }
}