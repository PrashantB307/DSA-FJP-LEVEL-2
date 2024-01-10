

//  https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1


import java.util.*;
class Solution
{
    public String FirstNonRepeating(String A){
        
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < A.length(); i++){
            char ch = A.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if(map.get(ch) == 1){
                q.add(ch);
            }

            while (!q.isEmpty() && map.get(q.peek()) > 1){
                q.remove();
            }

            if(q.isEmpty()){
                ans.append('#');
            }else{
                ans.append(q.peek());
            }
        }

        return ans.toString();
    }
}