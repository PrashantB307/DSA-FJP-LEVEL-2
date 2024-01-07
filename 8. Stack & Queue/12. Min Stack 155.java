

//    https://leetcode.com/problems/min-stack/

//    https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1

//    https://www.codingninjas.com/studio/problems/min-stack_3843991



import java.util.*;

class MinStack {

    Stack<Long> st;
    Long min;

    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        
        long val1 = val;

        if(st.size() == 0){
            st.push(val1);
            min = val1;
        }else if(val1 >= min){
            st.push(val1);
        }else{
            st.push(val1 + val1 - min);
            min = val1;
        }

    }
    
    public void pop() {
        
        if(st.peek() >= min){
            st.pop();
        }else{
            min = 2 * min - st.peek();
            st.pop();
        }
    }
    
    public int top() {
        
        if(st.peek() >= min){
            return st.peek().intValue();
        }else{
            return min.intValue();
        }
    }
    
    public int getMin() {
        return min.intValue();
    }
}



// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class MinStack2 {

    Stack<Integer> st;
    Stack<Integer> minStack ;

    public MinStack2() {
        st = new Stack<>();
        minStack  = new Stack<>();
    }
    
    public void push(int val) {
        if(st.size() == 0){
            st.push(val);
            minStack.push(val);
        }else if(val <= minStack.peek()){
            st.push(val);
            minStack.push(val);
        }else{
             st.push(val);
        }
    }
    
    public void pop() {
        if(st.peek().equals(minStack.peek())){
            st.pop();
            minStack.pop();
        }else{
            st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}