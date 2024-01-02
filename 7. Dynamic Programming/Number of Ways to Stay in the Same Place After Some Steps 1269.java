

//    https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/description/


class Solution {
    public int numWays(int steps, int arrLen) {
        
        int mod = 1000000007;
        int maxCol = Math.min(arrLen - 1, steps);

        int[][] dp = new int[2][maxCol + 1];
        dp[0][0] = 1;

        for(int i = 1; i <= steps; i++){
            for(int j = 0; j <= maxCol; j++){
                dp[i % 2][j] = dp[(i - 1) % 2][j];

                if(j - 1 >= 0){
                    dp[i % 2][j] = (dp[i % 2][j] + dp[(i - 1) % 2][j - 1]) % mod;
                }
                if(j + 1 <= maxCol){
                    dp[i % 2][j] = (dp[i % 2][j] + dp[(i - 1) % 2][j + 1]) % mod;
                }
            }
        }

        return dp[steps % 2][0];
    }
}