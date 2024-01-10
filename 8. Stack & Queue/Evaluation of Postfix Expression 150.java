

//    https://practice.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1

//    https://leetcode.com/problems/evaluate-reverse-polish-notation/


import java.util.*;
class Solution{

    public static int evaluatePostFix(String S){
        
        Stack<Integer> ans = new Stack<>();
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);

            if(ch >= '0' && ch <= '9'){
                ans.push(ch - '0');
            }else{
                int val2 = ans.pop();
                int val1 = ans.pop();

                int nval = operation(val1, val2, ch);
                ans.push(nval);
            }
        }

        return ans.peek();

    }

    public static int operation(int val1, int val2, char op){

        if(op == '+'){
            return val1 + val2;
        }else if(op == '-'){
            return val1 - val2;
        }else if(op == '*'){
            return val1 * val2;
        }else{
            return val1 / val2;
        }
    }
}


//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

class Solution2 {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stk = new Stack<>();
        for (String tok : tokens) {
            if (tok.equals("+")) {
                int n1 = stk.pop();  
                int n2 = stk.pop();  
                int res = n2 + n1;  
                stk.push(res);       
            } else if (tok.equals("-")) {
                int n1 = stk.pop();  
                int n2 = stk.pop();  
                int res = n2 - n1;   
                stk.push(res);       
            } else if (tok.equals("*")) {
                int n1 = stk.pop();  
                int n2 = stk.pop();  
                int res = n2 * n1;   
                stk.push(res);       
            } else if (tok.equals("/")) {
                int n1 = stk.pop();  
                int n2 = stk.pop();  
                int res = n2 / n1;  
                stk.push(res);       
            } else {
                stk.push(Integer.parseInt(tok));
            }
        }
        return stk.pop();
    }
}