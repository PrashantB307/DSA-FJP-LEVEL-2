

//     https://leetcode.com/problems/split-array-largest-sum/

//     https://practice.geeksforgeeks.org/problems/split-array-largest-sum--141634/1


class Solution {
    public int splitArray(int[] nums, int k) {
        
        int hi = 0;
        int lo = Integer.MIN_VALUE;

        for(int val : nums){
            hi += val;
            lo = Math.max(lo, val);
        }

        while(lo < hi){
            int mid = (lo + hi) / 2;
            int limit = mid;

            int countPart = 1;
            int currPartSum = 0;

            for(int val : nums){
                if(currPartSum + val <= limit){
                    currPartSum += val;
                }else{
                    currPartSum = val;
                    countPart++;
                }
            }

            if(countPart > k){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }

        return lo;
    }
}
