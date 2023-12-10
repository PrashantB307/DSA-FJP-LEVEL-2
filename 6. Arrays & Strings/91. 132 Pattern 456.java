

//     https://practice.geeksforgeeks.org/problems/132-geeky-buildings--141631/1

//     https://leetcode.com/problems/132-pattern/description/?envType=daily-question&envId=2023-09-30


import java.util.*;
class Solution{
    static boolean recreationalSpot(int[] arr , int n){
        
        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < third){
                return true;
            } 
            
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                third = stack.pop();
            }
            
            stack.push(arr[i]);
        }
        
        return false;
    }
};