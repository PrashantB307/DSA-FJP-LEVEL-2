
import java.util.*;
class Solution {
   
    public static String infixToPrefix(String exp) {
        
        Stack<Character> opStack = new Stack<>();
        Stack<String> preSt = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == '('){
                opStack.push(ch);

            }else if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')){
                preSt.push(ch + "");

            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^'){

                while(opStack.size() > 0 && opStack.peek() != '(' && precedence(ch) <= precedence(opStack.peek())){
                    conversion(opStack, preSt);
                }

                opStack.push(ch);
            }else if(ch == ')'){

                while(opStack.size() > 0 && opStack.peek() != '('){
                    conversion(opStack, preSt);
                }

                opStack.pop();
            }
        }

        while(opStack.size() > 0){
            conversion(opStack, preSt);
        }

        return preSt.peek();
    }

    static void conversion(Stack<Character> opStack, Stack<String> preSt){
        char op = opStack.pop();

        String val2 = preSt.pop();
        String val1 = preSt.pop();

        preSt.push(op + val1 + val2);
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