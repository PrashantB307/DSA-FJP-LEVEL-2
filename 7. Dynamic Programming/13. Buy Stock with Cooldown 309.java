

//     https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

//     https://practice.geeksforgeeks.org/problems/buy-stock-with-cooldown/1



class Solution {
    public int maxProfit(int[] prices) {
         
        int obsp = -prices[0];  // old buy state profit
        int ossp = 0;           // old sell state profit
        int ocsp = 0;           // old cool state profit
        
        for(int i = 1; i < prices.length; i++){
            int nbsp = Math.max(ocsp - prices[i], obsp);
            int nssp = Math.max(obsp + prices[i], ossp);
            int ncsp = Math.max(ocsp, ossp);

            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }

        return ossp;
    }
}