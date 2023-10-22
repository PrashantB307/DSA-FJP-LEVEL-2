

//    https://practice.geeksforgeeks.org/problems/gold-mine-problem2608/1


class Solution{
    static int maxGold(int n, int m, int arr[][])
    {
        int[][] dp = new int[n][m];
        
        for(int j = m - 1; j >= 0; j--){
            for(int i = 0; i < n; i++){
                
                int rightup = (j == m - 1 || i == 0) ? 0 :dp[i - 1][j + 1];
                int right = (j == m - 1) ? 0 : dp[i][j + 1];
                int rightdown = (j == m - 1 || i == n - 1) ? 0 : dp[i + 1][j + 1];
                
                int max = Math.max(right, Math.max(rightup, rightdown));
                dp[i][j] = arr[i][j] + max;
            }
        }

        int res = dp[0][0];
        for(int i = 1; i < n; i++){
            res = Math.max(dp[i][0], res);
        }

        return res;
    }
}