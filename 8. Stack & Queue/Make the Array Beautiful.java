

//   https://practice.geeksforgeeks.org/problems/make-the-array-beautiful--170647/1


import java.util.*;
class Solution {
    public static ArrayList<Integer> makeBeautiful(int[] arr) {
       
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new  ArrayList<>();


        for(int num : arr){
             if(stack.empty()) {
                stack.push(num);
            } else {
                if((stack.peek() >= 0 && num < 0) || (stack.peek() < 0 && num >= 0)) {
                    stack.pop();
                } else {
                    stack.push(num);
                }
            }
        }

        while(stack.size() > 0){
            res.add(stack.pop());
        }
        
        Collections.reverse(res);
        
        return res;
    }
}