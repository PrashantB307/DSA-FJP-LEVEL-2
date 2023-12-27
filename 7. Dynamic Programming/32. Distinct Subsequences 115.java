

//   https://leetcode.com/problems/distinct-subsequences/

//   https://practice.geeksforgeeks.org/problems/distinct-occurrences/1

//   https://www.codingninjas.com/studio/problems/distinct-subsequences_981277



class Solution {
    public int numDistinct(String s, String t) {
        
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }else if(i == 0){
                    dp[i][j] = 1;
                }else if(j == 0){
                    dp[i][j] = 0;
                }else{
                    if(s.charAt(i - 1) == t.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    }else{
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}