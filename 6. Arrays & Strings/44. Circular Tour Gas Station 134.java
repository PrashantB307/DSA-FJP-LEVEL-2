

//     https://leetcode.com/problems/gas-station/

//     https://practice.geeksforgeeks.org/problems/circular-tour-1587115620/1


class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int osum = 0;   // Overall sum
        int csum = 0;   // Current sum
        int idx = 0;


        for(int i = 0; i < gas.length; i++){
            osum += (gas[i] - cost[i]);
            csum += (gas[i] - cost[i]);

            if(csum < 0){
                csum = 0;
                idx = i + 1;
            }
        }

        if(osum >= 0){
            return idx;
        }else{
            return -1;
        }
    }
}