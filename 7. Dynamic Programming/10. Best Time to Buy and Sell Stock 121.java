

//    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 

class Solution {
    public int maxProfit(int[] prices) {

        int bp = prices[0]; // bp = buying point
        int maxprof = 0;

        for (int i = 1; i < prices.length; i++) {
            bp = Math.min(prices[i], bp);

            int pist = prices[i] - bp;
            maxprof = Math.max(maxprof, pist);
        }

        return maxprof;

    }
}