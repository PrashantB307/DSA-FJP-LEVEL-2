

//       https://leetcode.com/problems/max-consecutive-ones-iii/

//       https://practice.geeksforgeeks.org/problems/maximum-consecutive-ones/1


class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int i = 0;
        int j = 0;
        int cz = 0;    // cz = count zero
        int res = 0;

        while(i < nums.length){
            if(nums[i] == 0){
                cz++;
            }

            while(cz > k){
                if(nums[j] == 0){
                    cz--;
                }
                j++;
            }

            int len = i - j + 1;
            res = Math.max(res, len);
        }

        return res;
    }
}