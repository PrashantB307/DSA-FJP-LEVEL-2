

//    https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1

//    https://www.codingninjas.com/studio/problems/longest-repeating-subsequence_1062697


class Solution{
    public int LongestRepeatingSubsequence(String str)
    {
        
        int[][] dp = new int[str.length() + 1][str.length() + 1];

        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = dp[0].length - 2; j >= 0; j--){
                if(str.charAt(i) == str.charAt(j) && i != j){
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][ j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}