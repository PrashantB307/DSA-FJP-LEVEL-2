
 
//     https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/

//     https://practice.geeksforgeeks.org/problems/maximum-profit4657/1

//     https://www.codingninjas.com/studio/problems/best-time-to-buy-and-sell-stock_1080698


class Solution {
    public int maxProfit(int k, int[] prices) {
        
        if(prices.length == 0 || k == 0){
            return 0;
        }

        int[][] dp = new int[k + 1][prices.length + 1];

        for(int i = 1; i <= k; i++){
            int maxp = Integer.MIN_VALUE;
            for(int j = 1; j < prices.length; j++){
                maxp = Math.max(maxp, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(maxp + prices[j], dp[i][j - 1]);
            }
        }

        return dp[k][prices.length - 1]; 
    }
}