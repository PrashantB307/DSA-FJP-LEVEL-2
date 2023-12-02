

//       https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

//       https://practice.geeksforgeeks.org/problems/capacity-to-ship-packages-within-d-days/1


class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int lo = Integer.MIN_VALUE;
        int hi = 0;

        for(int val : weights){
            hi += val;
            lo = Math.max(lo, val); 
        }

        while(lo < hi){
            int mid = (lo + hi) / 2;
            int limit = mid;

            int currPart = 1;
            int currPartSum = 0;

            for(int val : weights){
                if(currPartSum + val <= limit){
                    currPartSum += val;
                }else{
                    currPart++;
                    currPartSum = val;
                }
            }

            if(currPart > days){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }

        return lo;
    }
}