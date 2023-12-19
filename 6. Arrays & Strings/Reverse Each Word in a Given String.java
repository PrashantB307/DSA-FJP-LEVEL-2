//    (Based on " . " ).
 

//     https://practice.geeksforgeeks.org/problems/reverse-each-word-in-a-given-string1001/1


import java.util.*;
class Solution {
    String reverseWords(String S) {
        Stack<Character> s1 = new Stack<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '.') {
                while (!s1.isEmpty()) {
                    str.append(s1.pop());
                }
                str.append('.');
            } else {
                s1.push(S.charAt(i));
            }

        }
        while (!s1.isEmpty()) {
            str.append(s1.pop());
        }

        return str.toString();
    }
}
