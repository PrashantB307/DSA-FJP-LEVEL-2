

//    https://leetcode.com/problems/house-robber-ii/



class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n < 2){
            return nums[0];
        }

        int[] skipFirstH = new int[n - 1];
        int[] skipLastH = new int[n - 1];

        for(int i = 0; i < n - 1; i++){
            skipLastH[i] = nums[i];
            skipFirstH[i] = nums[i + 1];
        }

        int loot1 = robber(skipFirstH);
        int loot2 = robber(skipLastH);

        return Math.max(loot1, loot2);
    }

    int robber(int[] nums){
        int n = nums.length;
        int[] ans = new int[n + 1];
        ans[0] = 0;
        ans[1] = nums[0];

        for(int i = 1; i < n; i++){
            int val = nums[i];
            ans[i + 1] = Math.max(ans[i], ans[i - 1] + val);
        }

        return ans[n];
    }
}