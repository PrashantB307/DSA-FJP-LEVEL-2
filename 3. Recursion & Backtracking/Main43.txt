

//    https://practice.geeksforgeeks.org/problems/remove-invalid-parentheses/1

//    https://leetcode.com/problems/remove-invalid-parentheses/



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Stack;
import java.util.Queue;
import java.util.Collections;

class Solution {
    public static ArrayList<String> removeInvalidParentheses(String s) {
        
        HashSet<String> set = new HashSet<>() ;     // To Avoid duplicate
        Queue<String> queue = new LinkedList<>();
        boolean isValidFound = false ;
        
        queue.add(s);
        
        ArrayList<String> result = new ArrayList<>();
        
        while(!queue.isEmpty() && !isValidFound){
            
            int size = queue.size() ;
            
            for(int i = 0; i < size; i++){
                
                String cur = queue.poll() ;
                
                if(isValid(cur)){
                    isValidFound = true ;
                    result.add(cur);
                }else if(!isValidFound){
                    
                    for(int j = 0; j < cur.length(); j++){
                        
                        if(Character.isLetter(cur.charAt(j))) continue ;
                        
                        String new_str = cur.substring(0, j) + cur.substring(j + 1);
                        
                        if(!set.contains(new_str)){
                            queue.add(new_str);
                            set.add(new_str);
                        }
                                              
                    }
                }
            }                        
        }
        
        Collections.sort(result);
        return result ;
    }
    
    static boolean isValid(String s)
    {
        Stack<Character> st=new Stack<>();
        for(int i = 0;i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch != '(' && ch != ')')
                continue;
            if(ch == '(')
                st.push(ch);
            else
            {
                if(!st.isEmpty() && st.peek() == '(')  
                    st.pop();
                else
                    return false;
            }
        }
        return st.isEmpty() ? true : false;
    }
}


// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// class Solution2 {
//     public static ArrayList<String> removeInvalidParentheses(String s) {
        
//         ArrayList<String> res = new ArrayList<>();
//         HashSet<String> ans = new HashSet<>();
        
//         int mr = getMin(s);
//         solution(s, mr, ans, res);

//         return res;
//     }

//     public static void solution(String str, int mr, HashSet<String> ans, ArrayList<String> res){

//         if(mr == 0){
//             int mrnow = getMin(str);
//             if(mrnow == 0){
//                 if(!ans.contains(str)){
//                     res.add(str);
//                     ans.add(str);
//                 }
//             }
//             return;
//         }

//         for(int i = 0; i < str.length(); i++){
//             String left = str.substring(0, i);
//             String right = str.substring(i + 1);
//             solution(left + right, mr - 1, ans, res);
//         }
//     }

//     public static int getMin(String str){
//         Stack<Character> st = new Stack<>();

//         for(int i = 0; i < str.length(); i++){
//             char ch = str.charAt(i);
//             if(ch == '('){
//                 st.push(ch);
//             }else if(ch == ')'){
//                 if(st.size() == 0){
//                     st.push(ch);
//                 }else if(st.peek() == ')'){
//                     st.push(ch);
//                 }else if(st.peek() == '('){
//                     st.pop();
//                 }
//             }
//         }

//         return st.size();
//     } 
// }