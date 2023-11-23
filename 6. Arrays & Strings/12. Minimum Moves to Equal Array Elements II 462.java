

//      https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/


import java.util.*;
class Solution {
    public int minMoves2(int[] nums) {
        
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        int moves = 0;

        while(i < j){
            moves += nums[j] - nums[i];
            i++;
            j--;
        }

        return moves;
    }
}