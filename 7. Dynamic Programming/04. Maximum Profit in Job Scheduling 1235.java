

//     https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/


import java.util.*;
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int[][] jobs = new int[startTime.length][3];
        for(int i = 0; i < jobs.length; i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        } 

        Arrays.sort(jobs, (b1, b2) -> {
            if(b1[0] != b2[0]){
                return b1[0] - b2[0];
            }else{
                return b1[1] - b2[1];
            }
        });

        int[] lis = new int[jobs.length];
        lis[0] = jobs[0][2];

        for(int i = 1; i < jobs.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(jobs[j][1] <= jobs[i][0]){
                    max = Math.max(max, lis[j]);
                }
            }

            lis[i] = max + jobs[i][2];
        }

        int len = 0;
        for(int val : lis){
            len = Math.max(val, len);
        }

        // for(int i = 1; i < nums.length; i++){
        //     if(nums[i] > tails[len - 1]){
        //         len++;
        //         tails[len - 1] = nums[i];
        //     }else{
        //         int idx = Arrays.binarySearch(tails, 0, len - 1, nums[i]);
        //         if(idx < 0){
        //             idx = -idx;
        //             idx = idx - 1;
        //         }

        //         tails[idx] = nums[i];
        //     }
        // }

        return len;
    }
}
