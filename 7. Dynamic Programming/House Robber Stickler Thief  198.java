

//    https://leetcode.com/problems/house-robber/description/

//    https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1


class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i = 1; i < n; i++){
            int val = nums[i];
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + val);
        }

        return dp[n];
    }
}