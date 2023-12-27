

//    https://practice.geeksforgeeks.org/problems/wildcard-pattern-matching/1

//    https://leetcode.com/problems/wildcard-matching/

//    https://www.codingninjas.com/studio/problems/wildcard-pattern-matching_701650


class Solution {
    int wildCard(String pat, String str) {
        boolean[][] dp = new boolean[str.length() + 1][pat.length() + 1];

        int n = str.length();
        int m = pat.length();

        for (int i = n; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {
                if (i == n && j == m) {
                    dp[i][j] = true;
                } else if (i == n) {
                    if (pat.charAt(j) == '*') {
                        dp[i][j] = dp[i][j + 1];
                    } else {
                        dp[i][j] = false;
                    }
                } else if (j == m) {
                    dp[i][j] = false;
                } else {
                    if (pat.charAt(j) == '?' || str.charAt(i) == pat.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else if (pat.charAt(j) == '*') {
                        dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }

        if(dp[0][0] == true){
            return 1;
        }else{
            return 0;
        }
    }
}
