

//    https://practice.geeksforgeeks.org/problems/lcs-of-three-strings0028/1

//    https://www.codingninjas.com/studio/problems/lcs-of-3-strings_842499


class Solution {
    int LCSof3(String s1, String s2, String s3, int n1, int n2, int n3) {
        int[][][] dp = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                for (int k = 1; k < n3 + 1; k++) {
                    char ch1 = s1.charAt(i - 1);
                    char ch2 = s2.charAt(j - 1);
                    char ch3 = s3.charAt(k - 1);

                    if (ch1 == ch2 && ch2 == ch3) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                    }

                    max = Math.max(max, dp[i][j][k]);
                }

            }
        }

        return max;

    }
}