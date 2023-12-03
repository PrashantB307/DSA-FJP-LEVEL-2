

//     https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/


class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        
        int lams = 1;   // lams = lowest allow max sum
        int hams = 0;   // hams = highest allow max sum

        for(int val : nums){
            hams = Math.max(val, hams);
        }

        while(lams < hams){
            int ams = (lams + hams) / 2;  // ams = allow max sum

            int opsReqd = 0;
            for(int ball : nums){
                if(ball > ams){
                    int spare = ball - ams;
                    int ops = (spare + ams - 1) / ams;
                    opsReqd += ops;
                }
            }

            if(opsReqd > maxOperations){
                lams = ams + 1;
            }else{
                hams = ams;
            }
        }

        return lams;
    }
}
