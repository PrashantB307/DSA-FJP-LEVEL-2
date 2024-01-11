

//    https://leetcode.com/problems/implement-stack-using-queues/


import java.util.*;
class MyStack {

    static Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.offer(x);
    }
    
    public int pop() {
        int val = 0;
        int size = q.size();
        while(size > 0){
            if(size == 1){
                val =  q.remove();
                break;
            }

            q.add(q.remove());
            size--;
        }

        return val;
    }
    
    public int top() {
        int top = 0;
        int size = q.size();
        while(size > 0){
            if(size == 1){
                top =  q.peek();
            }

            q.add(q.remove());
            size--;
        }

        return top;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}