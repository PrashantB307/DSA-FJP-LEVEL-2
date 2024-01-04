

//    https://leetcode.com/problems/maximal-rectangle/

//    https://practice.geeksforgeeks.org/problems/max-rectangle/1

//    https://www.codingninjas.com/studio/problems/maximum-size-rectangle-sub-matrix-with-all-1-s_893017



import java.util.*;
class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int[] ht = new int [matrix[0].length];

        for(int j = 0; j < matrix[0].length; j++){
            ht[j] = matrix[0][j] == '0' ? 0 : 1;  //  use Zero (0) insted of '0' in GFG
        }

        int res = largestRectangleArea(ht);

        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                ht[j] = matrix[i][j] == '0' ? 0 : ht[j] + 1;
            }

            int res2 = largestRectangleArea(ht);
            res = Math.max(res, res2);
        }

        return res;
    }

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