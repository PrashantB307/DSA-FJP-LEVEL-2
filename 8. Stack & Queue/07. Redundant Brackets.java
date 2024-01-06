

//   https://www.codingninjas.com/studio/problems/redundant-brackets_975473?leftPanelTab=1

//   https://www.interviewbit.com/problems/redundant-braces/


import java.util.*;
class Solution {
    public static boolean findRedundantBrackets(String s){

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if("(+-*/".indexOf(ch) != -1){
                st.push(ch);
            }else if(ch == ')'){
                if(st.peek() == '('){
                    return false;
                }else{
                    while(st.peek() != '('){
                        st.pop();
                    }
                    st.pop();
                }
            }
        }

        return true;
       
    }
}