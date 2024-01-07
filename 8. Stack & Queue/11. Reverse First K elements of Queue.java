

//    https://practice.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1

//    https://www.codingninjas.com/studio/problems/reverse-first-k-elements-of-queue_982771


import java.util.*;
class GfG {
   
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
       
        
        int size = q.size();
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < k; i++){
            st.push(q.remove());
        }

        while(st.size() > 0){
            q.add(st.pop());
        }

        for(int i = 0; i < size - k; i++){
            q.add(q.remove());
        }

        return q;
    }
}