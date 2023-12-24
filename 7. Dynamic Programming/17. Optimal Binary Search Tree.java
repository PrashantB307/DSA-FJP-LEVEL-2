

//    https://practice.geeksforgeeks.org/problems/optimal-binary-search-tree2214/1

//    https://www.codingninjas.com/studio/problems/optimal-bst_1062671?leftPanelTab=1


class Solution
{
    static int optimalSearchTree(int keys[], int freq[], int n)
    {
       
        int[][] dp = new int[n][n];
        int[] psa = new int[n];
        psa[0] = freq[0];
        for(int i = 1; i < n; i++){
            psa[i] = psa[i - 1] + freq[i];
        }

        for(int g = 0; g < dp[0].length; g++){
            for(int i = 0, j = g; j < dp[0].length; j++, i++){
                if(g == 0){
                    dp[i][j] = freq[i];
                }else if(dp[i][j] == 1){
                    dp[i][j] = Math.min(1 * freq[i] + 2 * freq[j], 2 * freq[i] + 1 * freq[j]);
                }else{

                    dp[i][j] = Integer.MAX_VALUE;

                    for(int k2 = g + 1, k1 = 1; k2 >= 1; k2--, k1++){
                        int left = (j - k2) == -1 ? 0 : dp[i][j - k2];
                        int right = (i + k1) == dp.length ? 0 : dp[i + k1][j];
                        int factor = psa[j] - (i > 0 ? psa[i - 1] : 0);

                        dp[i][j] = Math.min(dp[i][j], left + right + factor);
                    }
                }
            }
        }

        return dp[0][dp[0].length - 1];
    }
}
