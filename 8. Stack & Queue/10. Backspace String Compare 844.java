

//   https://leetcode.com/problems/backspace-string-compare/description/


import java.util.*;
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch != '#'){
                st1.push(ch);
            }else if(st1.size() > 0){
                st1.pop();
            }else{

            }
        }
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);

            if(ch != '#'){
                st2.push(ch);
            }else if(st2.size() > 0){
                st2.pop();
            }else{

            }
        }

        if(st1.size() != st2.size()){
            return false;
        }
        while(st1.size() > 0 && st1.size() > 0){
            if(st1.peek() != st2.peek()){
                return false;
            }
            st1.pop();
            st2.pop();
        }

        return true;

    }
}