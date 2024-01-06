

//    https://practice.geeksforgeeks.org/problems/count-the-reversals0401/1

//    https://www.codingninjas.com/studio/problems/minimum-cost-to-make-string-valid_1115770



import java.util.*;
class Sol{
    int countRev (String s){

        if(s.length() % 2 != 0){
            return -1;
        }

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '{'){
                st.push(ch);
            }else if(st.size() == 0){
                st.push(ch);
            }else if(st.peek() == '}'){
                st.push(ch);
            }else{
                st.pop();
            }
        }

        int open = 0;
        int close = 0;

        while(st.size() > 0){
            if(st.peek() == '{'){
                open++;
            }else{
                close++;
            }

            st.pop();
        }

        return (open + 1) / 2 + (close + 1) / 2;
    }
}