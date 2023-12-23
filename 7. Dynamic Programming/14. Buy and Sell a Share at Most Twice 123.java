

//     https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

//     https://practice.geeksforgeeks.org/problems/buy-and-sell-a-share-at-most-twice/1



class Solution {
    public int maxProfit(int[] prices) {
        
        int[] dps = new int[prices.length];
        
        int lpsf = prices[0];   // lpsf = lowest price so far
        dps[0] = 0;

        for(int i = 1; i < prices.length; i++){
            lpsf = Math.min(lpsf, prices[i]);   

            int pist = prices[i] - lpsf;     // pist = price if sell today
            dps[i] = Math.max(dps[i - 1], pist);
        }

        int[] dpb = new int[prices.length];
        
        int mpsf = prices[prices.length - 1];   // mpsf = max price so far
        dpb[dpb.length - 1] = 0;

        for(int i = prices.length - 2; i >= 0; i--){
            mpsf = Math.max(mpsf, prices[i]);

            int pibt = mpsf - prices[i];       // pibt = price if buy today
            dpb[i] = Math.max(dpb[i + 1], pibt);
        }

        int val = 0;
        for(int i = 0; i < prices.length; i++){
            val = Math.max(dps[i] + dpb[i],  val);
        }

        return val;

    }
}
