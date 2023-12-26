

//   https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1

//   https://www.codingninjas.com/studio/problems/longest-common-substring_1235207


class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        int max = Integer.MIN_VALUE;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                char ch1 = s1.charAt(i - 1);
                char ch2 = s2.charAt(j - 1);

                if(ch1 == ch2){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = 0;
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}