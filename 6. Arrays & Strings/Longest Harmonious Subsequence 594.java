

//    https://leetcode.com/problems/longest-harmonious-subsequence/description/

//    https://www.codingninjas.com/studio/problems/longest-harmonious-subsequence_1235206


import java.util.*;
class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);

        int l = 0;
        int r = 1;

        int max = 0;

        while(r < nums.length){
            while( nums[r] - nums[l] > 1){
                l++;
            }
            if( nums[r] - nums[l] == 1){
                  max = Math.max(max, (r - l) + 1);

            }
            r++;
        }
        return max;
    }
}