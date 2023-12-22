

//      https://practice.geeksforgeeks.org/problems/nth-catalan-number0817/1

//     https://www.codingninjas.com/studio/problems/catalan-number_893076


class Solution {
    static int mod = 1000000007;
    public static int findCatalan(int n) {
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            dp[i] = 0;
            for(int j = 0; j < i; j++){
                dp[i] = (dp[i] + (dp[j] * dp[i - j - 1]) % mod) % mod;
            }
        }
        
        return (int)dp[n];
    }
}  
  