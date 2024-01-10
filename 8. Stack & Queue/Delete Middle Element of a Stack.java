

//   https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1



import java.util.*;
class Solution {
    
    public void deleteMid(Stack<Integer> inputStack, int N) {
        Stack<Integer> temp = new Stack<>();

        for (int i = 0; i < N / 2; i++) {
            int num = inputStack.peek();
            inputStack.pop();
            temp.push(num);
        }

        inputStack.pop();

        while (!temp.isEmpty()) {
            int num = temp.peek();
            temp.pop();
            inputStack.push(num);
        }
    }
}
