

//    https://leetcode.com/problems/ones-and-zeroes/description/


class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        
        return helper(strs, 0, m, n, dp);
    }

    public int helper(String[] arr, int idx, int m, int n, int[][][] dp){
        if(idx == arr.length){
            return 0;
        }else if(dp[idx][m][n] != 0){
            return dp[idx][m][n];
        }

        String str = arr[idx];
        int cz = 0;
        int co = 0;

        for(char ch : str.toCharArray()){
            if(ch == '0'){
                cz++;
            }else{
                co++;
            }
        }

        int no = 0 + helper(arr, idx + 1, m, n, dp);
        int yes = 0;

        if(cz <= m && co <= n){
            yes = 1 + helper(arr, idx + 1, m - cz, n - co, dp);
        }

        int res = Math.max(no, yes);

        dp[idx][m][n] = res;
        return res;
    }
}