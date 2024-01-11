

//   https://practice.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1
 
//   https://www.codingninjas.com/studio/problems/infix-to-postfix_1382146


import java.util.*;
class Solution {
   
    public static String infixToPostfix(String exp) {
        
        Stack<Character> opStack = new Stack<>();
        Stack<String> postSt = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == '('){
                opStack.push(ch);

            }else if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')){
                postSt.push(ch + "");

            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^'){

                while(opStack.size() > 0 && opStack.peek() != '(' && precedence(ch) <= precedence(opStack.peek())){
                    conversion(opStack, postSt);
                }

                opStack.push(ch);
            }else if(ch == ')'){

                while(opStack.size() > 0 && opStack.peek() != '('){
                    conversion(opStack, postSt);
                }

                opStack.pop();
            }
        }

        while(opStack.size() > 0){
            conversion(opStack, postSt);
        }

        return postSt.peek();
    }

    static void conversion(Stack<Character> opStack, Stack<String> postSt){
        char op = opStack.pop();

        String val2 = postSt.pop();
        String val1 = postSt.pop();

        postSt.push(val1 + val2 + op);
    }

    static int precedence(char ch){
        if(ch == '+'){
            return 1;
        }else if(ch == '-'){
            return 1;
        }else if(ch == '*'){
            return 2;
        }else if(ch == '/'){
            return 2;
        }else{
            return 3;
        }
    }
}