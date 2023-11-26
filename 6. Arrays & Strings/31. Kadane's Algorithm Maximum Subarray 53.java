

//     https://leetcode.com/problems/maximum-subarray/

//     https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1


class Solution {
    public int maxSubArray(int[] nums) {
        
        int res = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(sum < 0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }

            res = Math.max(sum, res);
        }

        return res;
    }
}
