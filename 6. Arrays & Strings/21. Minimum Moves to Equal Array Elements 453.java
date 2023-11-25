


//     https://leetcode.com/problems/minimum-moves-to-equal-array-elements/


class Solution {
    public int minMoves(int[] nums) {
        int m = Integer.MAX_VALUE;
        for(int num : nums){
            m = Math.min(m, num);
        }

        int moves = 0;
        for(int num : nums){
            moves += num - m;
        }

        return moves;
    }
}
