

//      https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/

//      https://practice.geeksforgeeks.org/problems/smallest-absolute-difference4320/1



import java.util.*;
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        Arrays.sort(nums);

        int lo = 0;
        for(int i = 0; i < nums.length - 1; i++){
            lo = Math.min(nums[i + 1] - nums[i], lo);
        }

        int hi = nums[nums.length - 1] - nums[0];

        while(lo < hi){
            int mid = (lo + hi) / 2;
            
            int count = 0;
            int j = 0;
            for(int i = 0; i < nums.length; i++){
                while(j < nums.length && nums[j] - nums[i] <= mid){
                    j++;
                }

                count += (j - i - 1); 
            }

            if(count < k){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }

        return lo;
    }
}