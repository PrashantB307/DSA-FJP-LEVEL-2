

//    https://practice.geeksforgeeks.org/problems/help-classmates--141631/1



import java.util.*;
class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	    int[] ans = new int[n];
	    Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++){
            while(st.size() > 0 && st.peek() < arr[i]){
                st.pop();
            }

            if(st.size() == 0){
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }

            st.push(arr[i]);
        }

        return ans;
	} 
}
