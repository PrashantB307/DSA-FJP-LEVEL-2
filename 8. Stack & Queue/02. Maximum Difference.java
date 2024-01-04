

//    https://practice.geeksforgeeks.org/problems/maximum-difference-1587115620/1


import java.util.*;
class Solution
{
    int findMaxDiff(int a[], int n)
    {
        int ans = 0;

        int[] left = nextSmallerLeft(a);
        int[] right = nextSmallerRight(a); 

        for(int i = 0; i < a.length; i++){
            ans = Math.max(ans, Math.abs(left[i] - right[i]));
        }

        return ans;
    }

    int[] nextSmallerRight(int[] arr){

        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i = 1; i < arr.length; i++){
            while(st.size() > 0 && arr[st.peek()] > arr[i]){
                ans[st.peek()] = arr[i];
                st.pop();
            }

            st.push(i);
        }

        return ans;
    }

    int[] nextSmallerLeft(int[] arr){

        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);

        for(int i = arr.length - 2; i >= 0; i--){
            while(st.size() > 0 && arr[st.peek()] > arr[i]){
                ans[st.peek()] = arr[i];
                st.pop();
            }

            st.push(i);
        }

        return ans;
    }
}