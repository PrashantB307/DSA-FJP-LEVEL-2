

//   https://leetcode.com/problems/largest-rectangle-in-histogram/

//   https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1

//   https://www.codingninjas.com/studio/problems/largest-rectangle-in-a-histogram_1058184



import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int[] left = nextSmallerLeft(heights);
        int[] right = nextSmallerRight(heights); 

        int max  = 0;
        for(int i = 0; i < heights.length; i++){
            max = Math.max(max, heights[i] * (right[i]  - left[i] - 1));
        }
        
        return max;
    }

    int[] nextSmallerRight(int[] arr){

        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        Arrays.fill(ans, arr.length);
        for(int i = 1; i < arr.length; i++){
            while(st.size() > 0 && arr[st.peek()] > arr[i]){
                ans[st.peek()] = i;
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

        Arrays.fill(ans, -1);
        for(int i = arr.length - 2; i >= 0; i--){
            while(st.size() > 0 && arr[st.peek()] > arr[i]){
                ans[st.peek()] = i;
                st.pop();
            }

            st.push(i);
        }

        return ans;
    }
}