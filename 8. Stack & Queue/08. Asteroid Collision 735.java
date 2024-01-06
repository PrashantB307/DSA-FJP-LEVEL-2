

//    https://leetcode.com/problems/asteroid-collision/description/

//    https://practice.geeksforgeeks.org/problems/asteroid-collision/1

//    https://www.codingninjas.com/studio/problems/asteroid-collision_977232



import java.util.*;
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < asteroids.length; i++){
            if(st.size() == 0){
                st.push(asteroids[i]);
            }else if(st.peek() < 0){
                st.push(asteroids[i]);
            }else if(asteroids[i] > 0){
                st.push(asteroids[i]);
            }else{
                while(st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])){
                    st.pop();
                }

                if(st.size() == 0){
                    st.push(asteroids[i]);
                }else if(st.peek() < 0){
                    st.push(asteroids[i]);
                }else if(st.peek() == Math.abs(asteroids[i])){
                    st.pop();
                }else if(st.peek() > Math.abs(asteroids[i])){

                }
            }
        }

        int[] ans = new int[st.size()];
        int idx = ans.length - 1;
        while(st.size() > 0){
            ans[idx] = st.pop();
            idx--;
        }

        return ans;
    }
}