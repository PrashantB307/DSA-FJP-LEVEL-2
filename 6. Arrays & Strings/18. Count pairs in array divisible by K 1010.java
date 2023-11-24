


//     https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

//     https://practice.geeksforgeeks.org/problems/count-pairs-in-array-divisible-by-k/1


class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        int[] fmap = new int[60];

        int res = 0;
        for(int t : time){
            int val = t % 60;

            if(val == 0){
                res += fmap[0];
            }else{
                res += fmap[60 - val];
            }

            fmap[val]++;
        }

        return res;
    }
}