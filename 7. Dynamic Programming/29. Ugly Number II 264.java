

//    https://leetcode.com/problems/ugly-number-ii/description/

//    https://practice.geeksforgeeks.org/problems/ugly-number-ii/1

//    https://www.codingninjas.com/studio/problems/ugly-numbers_3114806


class Solution {
    public int nthUglyNumber(int n) {
        
        int[] dp = new int[n + 1];

        dp[1] = 1;
        int iof2 = 1;    // iof2 = Index of 2
        int iof3 = 1;    // iof3 = Index of 3
        int iof5 = 1;    // iof5 = Index of 5

        for(int i = 2; i <= n; i++){

            int mof2 = dp[iof2] * 2;   // mof2 = Multi of 2
            int mof3 = dp[iof3] * 3;
            int mof5 = dp[iof5] * 5;

            dp[i] = Math.min(mof2, Math.min(mof3, mof5));

            if(dp[i] == mof2){
                iof2++;
            }
            if(dp[i] == mof3){
                iof3++;
            }
            if(dp[i] == mof5){
                iof5++;
            }
        }

        return dp[n];
    }
}