

//   https://leetcode.com/problems/palindromic-substrings/

//   https://practice.geeksforgeeks.org/problems/count-palindrome-sub-strings-of-a-string0652/1


class Solution {
    public int countSubstrings(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int cnt = 0;

        for(int g = 0; g < n; g++){
            for(int i = 0, j = g; j < dp.length; i++, j++){
                if(g == 0){
                    dp[i][j] = true;
                }else if(g == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }

                if(dp[i][j] == true){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}


//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX=====>    GFG     <======XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class Solution2 {
    public boolean Palindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int CountPS(String S, int N) {
        // code here
        int count = 0;
        for (int i = 0; i <= N - 1; i++) {
            for (int j = i + 2; j <= N; j++) {
                String s = S.substring(i, j);
                if (Palindrome(s) && s.length() >= 2) {
                    count++;
                }
            }
        }
        return count;
    }
}