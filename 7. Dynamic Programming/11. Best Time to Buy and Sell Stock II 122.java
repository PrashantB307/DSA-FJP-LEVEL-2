

//     https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

//     https://practice.geeksforgeeks.org/problems/stock-buy-and-sell2615/1


class Solution {
    public int maxProfit(int[] prices) {
        
        int bd = 0;   // bd = buying date
        int sd = 0;   // sd = selling date
        int prof = 0;

        for(int i = 1; i < prices.length; i++){
            if(prices[i] >= prices[i - 1]){
                sd++;
            }else{
                prof += prices[sd] - prices[bd];
                sd = bd = i;
            }
        }

        prof += prices[sd] - prices[bd];

        return prof;

    }
}