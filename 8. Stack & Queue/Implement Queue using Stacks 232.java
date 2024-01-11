

//   https://leetcode.com/problems/implement-queue-using-stacks/

//   https://www.geeksforgeeks.org/problems/queue-using-stack/1


import java.util.*;
class MyQueue {

    Deque<Integer> dq1;
    Deque<Integer> dq2;

    public MyQueue() {
        
        dq1 = new ArrayDeque<>();
        dq2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        dq1.push(x);
        
    }
    
    public int pop() {
        helper();
        return dq2.pop();
    }
    
    public int peek() {
        helper();
        return dq2.peek();
    }
    
    public boolean empty() {
        if(dq1.isEmpty() && dq2.isEmpty()){
            return true;
        }

        return false;
    }

    public void helper(){
        while (dq1.isEmpty()) {
            while (!dq2.isEmpty()) {
                dq2.push(dq1.pop());
            }
        }
    }
}


// XXXXXXXXXXXXXXXXXXXXXXXXX======>   GFG    <=======XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class Queue
{
    Stack<Integer> input = new Stack<Integer>(); 
    Stack<Integer> output = new Stack<Integer>(); 
    
    /*The method pop which return the element poped out of the stack*/
    int dequeue()
    {
	    helper();
	    return output.pop();
    }
	
    /* The method push to push element into the stack */
    void enqueue(int x)
    {
	    input.push(x);
    }
    
    void helper(){
        while(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
    }
}

