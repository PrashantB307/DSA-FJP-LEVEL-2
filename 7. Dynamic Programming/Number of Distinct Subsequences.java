

//    https://practice.geeksforgeeks.org/problems/number-of-distinct-subsequences0909/1

//    https://www.codingninjas.com/studio/problems/distinct-subsequences_799558?leftPanelTab=1


import java.util.*;
class Solution {
    int mod = 1000000007;
    int distinctSubsequences(String S) {
        
        long[] dp = new long[S.length() + 1];
        dp[0] = 1;

        HashMap<Character, Integer> locc = new HashMap<>();
        // locc => last Occurense

        for(int i = 1; i < dp.length; i++){
            dp[i] = (2 * dp[i - 1]) % mod;

            char ch = S.charAt(i - 1);

            if(locc.containsKey(ch)){
                int j = locc.get(ch);
                dp[i] = dp[i] - dp[j - 1];
                dp[i] = (dp[i] + mod) % mod;
            }

            locc.put(ch, i);
        }

        return (int)dp[S.length()];
    }
}