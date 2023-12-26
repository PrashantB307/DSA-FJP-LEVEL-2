

//   https://leetcode.com/problems/super-ugly-number/


import java.util.*;
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        long[] dp = new long[n + 1];
        dp[1] = 1;

        int[] indexs = new int[primes.length];
        Arrays.fill(indexs, 1);

        for(int i = 2; i <= n; i++){
            long ans = Long.MAX_VALUE;

            for(int j = 0; j < primes.length; j++){
                int prime = primes[j];
                int idx = indexs[j];
                
                ans = Math.min(ans, dp[idx] * prime);
            }

            for(int j = 0; j < primes.length; j++){
                int prime = primes[j];
                int idx = indexs[j];
                
                if(ans == dp[idx] * prime){
                    indexs[j] = idx + 1;
                }
            }

            dp[i] = ans;
        }

        return (int)dp[n];
    }
}