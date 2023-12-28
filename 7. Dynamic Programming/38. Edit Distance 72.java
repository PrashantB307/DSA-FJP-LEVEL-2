

//   https://leetcode.com/problems/edit-distance/

//   https://practice.geeksforgeeks.org/problems/edit-distance3702/1

//   https://www.codingninjas.com/studio/problems/edit-distance_630420


class Solution {
    public int minDistance(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();
        
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++){
            dp[i][0] = i;
        }

        for(int i = 0; i <= n; i++){
            dp[0][i] = i;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[m][n];

    }
}