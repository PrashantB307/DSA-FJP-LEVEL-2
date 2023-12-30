

//   https://leetcode.com/problems/minimum-cost-to-cut-a-stick/


import java.util.*;
class Solution {
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int val : cuts){
            list.add(val);
        }

        list.add(0);
        list.add(n);
        Collections.sort(list);

        int[][] dp = new int[list.size()][list.size()];

        for(int g = 2; g < dp[0].length; g++){
            for(int i = 0, j = g; j < dp[0].length; i++, j++){
                dp[i][j] = Integer.MAX_VALUE;

                for(int k1 = 1, k2 = g - 1; k1 < g; k1++, k2--){
                    int left = dp[i][j - k2];
                    int right = dp[i + k1][j];
                    int factor = list.get(j) - list.get(i);

                    dp[i][j] = Math.min(dp[i][j], factor + left + right);
                }
            }
        }

        return dp[0][dp[0].length -1];
    }
}