

//    https://www.codingninjas.com/studio/problems/highway-billboards_3125967?leftPanelTab=1


class Solution {

	public static int highwayBillboard(int[] billboards, int[] revenue, int m, int x) {
	 	
        int[] dp = new int[billboards.length];
        dp[0] = revenue[0];
        int omax = revenue[0];

        for(int i = 1; i < dp.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(billboards[j] + x < billboards[i]){
                    max = Math.max(max, dp[j]);
                }
            }

            dp[i] = max + revenue[i];
            omax = Math.max(omax, dp[i]);
        }

        return omax;
	}

}