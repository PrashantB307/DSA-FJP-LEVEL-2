

//   https://leetcode.com/problems/distinct-subsequences-ii/

//   https://practice.geeksforgeeks.org/problems/number-of-distinct-subsequences0909/1

//   https://www.codingninjas.com/studio/problems/distinct-subsequences_799558



import java.util.*;
class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 2;

        int[] lo = new int[26];   // lo = Last Occurance
        lo[s.charAt(0) - 'a'] = 1;

        for(int i = 2; i < dp.length; i++){

            dp[i] = (2 * dp[i - 1]) % mod;
            
            int ch = s.charAt(i - 1) - 'a';
            if(lo[ch] != 0){
                dp[i] = (dp[i] - dp[lo[ch] - 1]) % mod;
            }

            lo[ch] = i;
        }

        return dp[s.length()] - 1 < 0 ? dp[s.length()] - 1 + mod :  dp[s.length()] - 1;
    }
}


// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


 class Solution2 { 
    public static int distinctSubsequences(String S) {
        int mod = 1000000007;
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