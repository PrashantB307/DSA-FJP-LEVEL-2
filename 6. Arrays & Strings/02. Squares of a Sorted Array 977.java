

//     https://leetcode.com/problems/squares-of-a-sorted-array/


class Solution {
    public int[] sortedSquares(int[] nums) {

        int [] ans = new int[nums.length];

        int l = 0;
        int r = nums.length - 1;
        int k = nums.length - 1;

        while(k >= 0){
            if(Math.abs(nums[l]) > Math.abs(nums[r])){
                ans[k] = nums[l] * nums[l];
                l++;
            }else{
                ans[k] = nums[r] * nums[r];
                r--;
            }

            k--;
        }
        
        return ans;
    }
}