

//   https://www.geeksforgeeks.org/problems/clone-a-stack-without-usinig-extra-space/1


import java.util.*;
class Solution {
    void clonestack(Stack<Integer> st, Stack<Integer> cloned) {
        
        for(int i = 0; i < st.size(); i++){
            cloned.push(st.get(i));
        }

    }
}