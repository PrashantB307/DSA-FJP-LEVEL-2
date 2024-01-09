

//    https://www.geeksforgeeks.org/problems/number-following-a-pattern3126/1


import java.util.*;
class Solution {
    static String printMinNumberForPattern(String s) {

        StringBuilder ans = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i <= n; i++) {
            st.push(i + 1);
            if (i == n || s.charAt(i) == 'I') {
                while (!st.isEmpty()) {
                    ans.append(st.pop());
                }
            }
        }
        return ans.toString();
    }
}