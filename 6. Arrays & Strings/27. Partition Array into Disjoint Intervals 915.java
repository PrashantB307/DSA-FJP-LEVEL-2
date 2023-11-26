


//     https://leetcode.com/problems/partition-array-into-disjoint-intervals/


class Solution {
    public int partitionDisjoint(int[] nums) {
        
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];

        for(int i = 1; i < nums.length; i++){
            left[i] = Math.max(nums[i], left[i - 1]);
        }

        for(int i = nums.length - 2; i >= 0; i--){
            right[i] = Math.min(nums[i], right[i + 1]);
        }

        int ans = -1;

        for(int i = 0; i < nums.length; i++){
            if(left[i] <= right[i + 1]){
                ans = i + 1;
                break;
            }
        }

        return ans;
    }
}


// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class Solution2 {
    public int partitionDisjoint(int[] nums) {
        int pi = 0;
        int mtp = nums[0];
        int mts = nums[0];

        for(int i = 1; i < nums.length; i++){
            mts = Math.max(mts, nums[i]);

            if(nums[i] < mtp){
                pi = i;
                mtp = mts;
            }
        }

        return pi + 1;
    }
}