

//     https://practice.geeksforgeeks.org/problems/unique-bsts-1587115621/1

//      https://leetcode.com/problems/unique-binary-search-trees/


class Solution
{
    static int numTrees(int N)
    {
        long mod = 1000000007;
        long[] dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= N; i++){
            for(int left = 0; left <= i - 1; left++){
                int right = i - left - 1;
                long val = (dp[left] * dp[right]) % mod;
                dp[i] = (dp[i] + val) % mod;
            }
        }

        return (int)dp[N];
    }
}
