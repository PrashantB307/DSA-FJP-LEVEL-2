

//     https://leetcode.com/problems/longest-increasing-subsequence/

//     https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1

//     https://www.codingninjas.com/studio/problems/longest-increasing-subsequence_630459



//------------------------>   n*logn   <-------------------------------


import java.util.*;
class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] tails = new int[nums.length];
        int len = 1;
        tails[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > tails[len - 1]){
                len++;
                tails[len - 1] = nums[i];
            }else{
                int idx = Arrays.binarySearch(tails, 0, len - 1, nums[i]);
                if(idx < 0){
                    idx = -idx;
                    idx = idx - 1;
                }

                tails[idx] = nums[i];
            }
        }

        return len;
    }
}



// XXXXXXXXXXXXXXXXXXXXXXXXXXXXX    O(n^2)    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class Solution2 {
    public int lengthOfLIS(int[] nums) {
        
        int[] lis = new int[nums.length];
        lis[0] = 1;   // lis = Longest increasing subsequence. 

        for(int i = 1; i < nums.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    max = Math.max(max, lis[j]);
                }
            }

            lis[i] = max + 1;
        }

        int len = 0;
        for(int val : lis){
            len = Math.max(val, len);
        }

        return len;
    }
}
