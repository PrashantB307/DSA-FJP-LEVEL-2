

//    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/

//    https://practice.geeksforgeeks.org/problems/buy-stock-with-transaction-fee/1


class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        int obsp = -prices[0];   // old buy state profit
        int ossp = 0;            // old sell state profit

        for(int i = 1; i < prices.length; i++){
            int nbsp = Math.max(obsp, ossp - prices[i]);
            int nssp = Math.max(ossp, obsp + prices[i] - fee);

            obsp = nbsp;
            ossp = nssp;
        }

        return ossp;
    }
}