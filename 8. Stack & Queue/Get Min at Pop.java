

//   https://practice.geeksforgeeks.org/problems/get-min-at-pop/1


import java.util.*;
class GetMin
{
    public static Stack<Integer> _push(int arr[],int n)
    {
        Stack<Integer> st = new Stack<>();
        int min = Integer.MAX_VALUE;;
        
        for(int i = 0; i < n; i++){
            min = Math.min(min, arr[i]);
            st.push(min);
        }
        
        return st;
    }
    
    static void _getMinAtPop(Stack<Integer>s)
    {
        while(s.size() > 0){
            System.out.print(s.pop() + " ");
        }
    }
}