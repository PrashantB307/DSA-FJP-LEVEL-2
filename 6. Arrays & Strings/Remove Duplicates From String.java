

//   https://practice.geeksforgeeks.org/problems/remove-duplicates3034/1

//   https://practice.geeksforgeeks.org/problems/remove-all-duplicates-from-a-given-string4321/1

//   https://www.codingninjas.com/studio/problems/remove-duplicates-from-string_630470


import java.util.*;
class Solution {
    public static String removeDuplicates(String S) 
    {
        String str = "";
       HashSet<Character> set = new HashSet<>();
       
       for(int i = 0; i < S.length(); i++){
           char ch = S.charAt(i);
           if(!set.contains(ch)){
               set.add(ch);
               str += ch;
           }
           
       }
       
       return str;
    }
}