

//    https://practice.geeksforgeeks.org/problems/longest-valid-parentheses5657/1

//    https://leetcode.com/problems/longest-valid-parentheses/description/

//    https://www.codingninjas.com/studio/problems/longest-valid-parentheses_1089563


import java.util.*;
class Solution{
    static int maxLength(String S){
       
        int res = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);

            if(ch == '('){
                st.push(i);
            }else{
                st.pop();

                if(st.size() > 0){
                    int len = i - st.peek();
                    res = Math.max(res, len);
                }else{
                    st.push(i);
                }
            }
        }

        return res;
    }
}