

//    https://leetcode.com/problems/validate-stack-sequences/

//    https://www.codingninjas.com/studio/problems/valid-stack-permutation_1170061


import java.util.*;
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int j = 0;

        while(i < pushed.length){
            st.push(pushed[i]);
            i++;

            while(st.size() > 0 && j < popped.length && st.peek() == popped[j]){
                st.pop();
                j++;
            }
        }
        
        return st.size() == 0;
    }
}